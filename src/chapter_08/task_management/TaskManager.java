package chapter_08.task_management;

import chapter_08.task_management.model.Task;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * TaskManager is a class that manages a list of tasks.
 * It provides methods to filter, transform, perform actions, and add tasks.
 */
public class TaskManager {
    private Set<Task> tasks;
    private Map<Integer, Task> taskMap;

    /**
     * Initializes a new TaskManager with a predefined list of tasks.
     */
    public TaskManager() {
        tasks = new HashSet<>();
        taskMap = new HashMap<>();
        tasks.add(new Task(1, "Complete project report", false, 1));
        tasks.add(new Task(2, "Pay electricity bill", true, 2));
        tasks.add(new Task(3, "Buy groceries", false, 3));
        tasks.add(new Task(4, "Schedule meeting with team", false, 1));
    }

    /**
     * Retrieves the list of tasks managed by this TaskManager.
     *
     * @return A list of tasks.
     */
    public Set<Task> getTasks() {
        return tasks;
    }

    /**
     * Filters tasks based on the provided criteria.
     *
     * @param criteria The condition to filter tasks.
     * @return A list of tasks that match the predicate.
     */
    public Set<Task> fiterTasks(Predicate<Task> criteria) {
        return tasks.stream()
                .filter(criteria)
                .collect(Collectors.toSet());
    }


    /**
     * Transforms the descriptions of all tasks using the provided function.
     *
     * @param description The function to apply to each task's description.
     */
    public void transformTaskDescription(Function<String, String> description) {
        tasks.forEach(task -> task.setDescription(description.apply(task.getDescription())));

    }

    /**
     * Performs an action on each task using the provided task.
     *
     * @param task The action to perform on each task.
     */

    public void performActionOnTask(Consumer<Task> task) {
        tasks.forEach(task);
    }

    /**
     * Adds a new task to the list using the provided supplier.
     *
     * @param newTaskSupplier The supplier that generates a new task.
     */
    public void addTask(Supplier<Task> newTaskSupplier) {
       tasks.add(newTaskSupplier.get());
    }

}

