package fr.esir.omd.ci;

/**
 * Représente une tâche avec un titre, une description et un état d'avancement.
 */
public class Task {
  private String title;
  private String description;
  private boolean completed;

  /**
   * Construit une nouvelle tâche.
   *
   * @param title le titre de la tâche
   * @param description la description détaillée de la tâche
   * @param completed {@code true} si la tâche est terminée, {@code false} sinon
   */
  public Task(String title, String description, boolean completed) {
    this.title = title;
    this.description = description;
    this.completed = completed;
  }

  /**
   * Retourne le titre de la tâche.
   *
   * @return le titre de la tâche
   */
  public String getTitle() {
    return title;
  }

  /**
   * Modifie le titre de la tâche.
   *
   * @param title le nouveau titre
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Retourne la description de la tâche.
   *
   * @return la description de la tâche
   */
  public String getDescription() {
    return description;
  }

  /**
   * Modifie la description de la tâche.
   *
   * @param description la nouvelle description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Indique si la tâche est terminée.
   *
   * @return {@code true} si la tâche est terminée, {@code false} sinon
   */
  public boolean isCompleted() {
    return completed;
  }

  /**
   * Modifie l'état d'avancement de la tâche.
   *
   * @param completed {@code true} pour marquer la tâche comme terminée
   */
  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}