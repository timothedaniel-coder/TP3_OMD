package fr.esir.omd.ci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests unitaires pour les classes {@link TaskManager} et {@link Task}.
 */
public class TaskManagerTest {

  @Test
  public void testAddAndGetTasks() {
    TaskManager manager = new TaskManager();
    assertTrue(manager.getTasks().isEmpty());

    Task task = new Task("TP OMD", "Tester la couverture JaCoCo", false);
    manager.addTask(task);

    assertEquals(1, manager.getTasks().size());
    assertEquals("TP OMD", manager.getTasks().get(0).getTitle());
    assertEquals("Tester la couverture JaCoCo", manager.getTasks().get(0).getDescription());
    assertFalse(manager.getTasks().get(0).isCompleted());
  }

  @Test
  public void testAddNullTaskIsIgnored() {
    TaskManager manager = new TaskManager();
    manager.addTask(null);
    assertEquals(0, manager.getTasks().size());
  }

  @Test
  public void testTaskSetters() {
    Task task = new Task("Initial", "Desc", false);
    task.setTitle("Modifié");
    task.setDescription("Nouvelle description");
    task.setCompleted(true);

    assertEquals("Modifié", task.getTitle());
    assertEquals("Nouvelle description", task.getDescription());
    assertTrue(task.isCompleted());
  }
}