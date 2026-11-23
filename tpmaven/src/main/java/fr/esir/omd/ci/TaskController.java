package fr.esir.omd.ci;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contrôleur JavaFX associé à la vue {@code TaskView.fxml}.
 */
public class TaskController {
  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

  @FXML private TextField titleField;
  @FXML private TextArea descriptionField;
  @FXML private Button saveJsonButton;
  @FXML private Button saveCsvButton;
  @FXML private Button savePdfButton;

  private final TaskManager manager;
  private final FileHandler fileHandler;

  /**
   * Construit le contrôleur et instancie le gestionnaire de tâches et d'exports.
   */
  public TaskController() {
    manager = new TaskManager();
    fileHandler = new FileHandler();
  }

  /**
   * Initialise les gestionnaires d'événements des boutons de l'interface.
   */
  public void initialize() {
    logger.debug("Configuration des boutons de l'interface TaskView");
    saveJsonButton.setOnAction(e -> saveTask("json"));
    saveCsvButton.setOnAction(e -> saveTask("csv"));
    savePdfButton.setOnAction(e -> saveTask("pdf"));
  }

  private void saveTask(String format) {
    logger.debug("Action d'enregistrement déclenchée pour le format : {}", format);
    String title = titleField.getText();
    String description = descriptionField.getText();

    if (title.isEmpty() || description.isEmpty()) {
      logger.warn(
          "Enregistrement annulé : les champs Titre et Description doivent être remplis.");
      return;
    }

    Task task = new Task(title, description, false);
    manager.addTask(task);

    try {
      switch (format) {
        case "json":
          fileHandler.saveAsJson(manager.getTasks(), "tasks.json");
          break;
        case "csv":
          fileHandler.saveAsCsv(manager.getTasks(), "tasks.csv");
          break;
        case "pdf":
          fileHandler.generatePdf(manager.getTasks(), "tasks.pdf");
          break;
        default:
          logger.warn("Format non supporté : {}", format);
      }
    } catch (Exception e) {
      logger.error("Erreur lors de l'enregistrement au format {}", format, e);
    }
  }
}