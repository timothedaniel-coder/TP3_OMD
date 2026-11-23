package fr.esir.omd.ci;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FileHandler {
    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);

    public void saveAsJson(List<Task> tasks, String filePath) throws IOException {
        logger.debug("Début de l'export JSON de {} tâche(s) vers {}", tasks.size(), filePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(tasks, writer);
        }
        logger.info("Export JSON terminé avec succès : {}", filePath);
    }

    public void saveAsCsv(List<Task> tasks, String filePath) throws IOException {
        logger.debug("Début de l'export CSV de {} tâche(s) vers {}", tasks.size(), filePath);
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("Title", "Description", "Completed")
                .build();
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), format)) {
            for (Task task : tasks) {
                printer.printRecord(task.getTitle(), task.getDescription(), task.isCompleted());
            }
        }
        logger.info("Export CSV terminé avec succès : {}", filePath);
    }

    public void generatePdf(List<Task> tasks, String filePath) throws DocumentException, IOException {
        logger.debug("Début de la génération PDF de {} tâche(s) vers {}", tasks.size(), filePath);
        Document document = new Document();
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            PdfWriter.getInstance(document, out);
            document.open();
            for (Task task : tasks) {
                document.add(new Paragraph("Title: " + task.getTitle()));
                document.add(new Paragraph("Description: " + task.getDescription()));
                document.add(new Paragraph("Completed: " + task.isCompleted()));
                document.add(new Paragraph("\n"));
            }
            document.close();
        }
        logger.info("Génération PDF terminée avec succès : {}", filePath);
    }
}