package fr.esir.omd.ci;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gère la collection en mémoire des tâches de l'application.
 */
public class TaskManager {
  private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
  private final List<Task> tasks;

  /**
   * Initialise un gestionnaire contenant une liste vide de tâches.
   */
  public TaskManager() {
    tasks = new ArrayList<>();
    logger.debug("Initialisation du gestionnaire de tâches");
  }

  /**
   * Ajoute une tâche à la liste si elle n'est pas nulle.
   *
   * @param task la tâche à ajouter
   */
  public void addTask(Task task) {
    if (task == null) {
      logger.warn("Tentative d'ajout d'une tâche nulle ignorée");
      return;
    }
    tasks.add(task);
    logger.info("Nouvelle tâche ajoutée : {}", task.getTitle());
  }

  /**
   * Retourne la liste des tâches enregistrées.
   *
   * @return la liste des tâches
   */
  public List<Task> getTasks() {
    logger.debug("Récupération de la liste des {} tâche(s)", tasks.size());
    return tasks;
  }

  // Code mort volontaire pour vérifier la détection par PMD
  private void unusedDeadCodeMethod() {
    int unusedVariable = 42;
  }
}