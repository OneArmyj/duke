import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    void getNumOfTasks() {
        TaskList task = new TaskList();
        task.addTask(new ToDos("do 2103"));
        task.addTask(new ToDos("do 2101"));
        assertEquals(1, task.getNumOfTasks());
    }
}