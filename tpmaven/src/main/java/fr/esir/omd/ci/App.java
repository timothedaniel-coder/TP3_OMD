package fr.esir.omd.ci;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Point d'entrée principal de l'application JavaFX de gestion de tâches.
 */
public class App extends Application {
  private static final Logger logger = LoggerFactory.getLogger(App.class);

  /**
   * Lance l'application JavaFX.
   *
   * @param args arguments de la ligne de commande
   */
  public static void main(String[] args) {
    logger.info("Démarrage de l'application Liste de Tâches");
    launch(args);
  }

  /**
   * Initialise et affiche la fenêtre principale à partir du fichier FXML.
   *
   * @param primaryStage la fenêtre principale fournie par JavaFX
   * @throws Exception en cas d'erreur lors du chargement du fichier FXML
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    logger.debug("Chargement de l'interface FXML /fr/esir/omd/ci/TaskView.fxml");
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/fr/esir/omd/ci/TaskView.fxml"));
    primaryStage.setTitle("Liste de Tâches");
    primaryStage.setScene(new Scene(loader.load()));
    primaryStage.show();
    logger.info("Fenêtre principale affichée");
  }
}