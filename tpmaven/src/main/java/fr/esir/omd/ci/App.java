package fr.esir.omd.ci;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Démarrage de l'application Liste de Tâches");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.debug("Chargement de l'interface FXML /fr/esir/omd/ci/TaskView.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/esir/omd/ci/TaskView.fxml"));
        primaryStage.setTitle("Liste de Tâches");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
        logger.info("Fenêtre principale affichée");
    }
}