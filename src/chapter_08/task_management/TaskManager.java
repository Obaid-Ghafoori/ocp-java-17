package chapter_08.task_management;

import chapter_08.task_management.model.Task;

import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "Complete project report", false, 1));
        tasks.add(new Task(2, "Pay electricity bill", true, 2));
        tasks.add(new Task(3, "Buy groceries", false, 3));
        tasks.add(new Task(4, "Schedule meeting with team", false, 1));
    }

    public List<Task> getTasks() {
        return tasks;
    }

}

