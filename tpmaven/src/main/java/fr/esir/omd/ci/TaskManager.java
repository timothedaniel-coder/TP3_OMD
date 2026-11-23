package fr.esir.omd.ci;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskManager {
    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
        logger.debug("Initialisation du gestionnaire de tâches");
    }

    public void addTask(Task task) {
        if (task == null) {
            logger.warn("Tentative d'ajout d'une tâche nulle ignorée");
            return;
        }
        tasks.add(task);
        logger.info("Nouvelle tâche ajoutée : {}", task.getTitle());
    }

    public List<Task> getTasks() {
        logger.debug("Récupération de la liste des {} tâche(s)", tasks.size());
        return tasks;
    }
}