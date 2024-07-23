package chapter_08.task_management;

import chapter_08.task_management.model.Task;

import java.util.List;

public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        //filter out the incomplete task
        List<Task> pendingTasks = taskManager.fiterTasks(task -> !task.isCompleted());
        System.out.println("\nPrinting pending tasks:");
        pendingTasks.stream().forEach(System.out::println);
    }
}
