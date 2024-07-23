package chapter_08.task_management;

import chapter_08.task_management.model.Task;

import java.util.List;
import java.util.Set;

public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        //filter out the incomplete task
        Set<Task> pendingTasks = taskManager.fiterTasks(task -> !task.isCompleted());
        System.out.println("\nPrinting pending tasks:");
        pendingTasks.stream().forEach(System.out::println);

        // printing transform tasks
        taskManager.transformTaskDescription(String::toUpperCase);

        System.out.println("\nTasks after transformations:");
        taskManager.getTasks().forEach(System.out::println);

        System.out.println("\nPerforming an action on the tasks:");
        taskManager.performActionOnTask(System.out::println);

        System.out.println("\nAdding new task to the backlog");
        taskManager.addTask(() -> new Task(2,"Review team performance", false, 2));
        taskManager.transformTaskDescription(String::toUpperCase);
        taskManager.performActionOnTask(System.out::println);

    }
}
