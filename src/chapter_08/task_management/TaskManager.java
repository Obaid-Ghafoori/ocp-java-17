package chapter_08.task_management;

import chapter_08.task_management.model.Task;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * TaskManager is a class that manages a list of tasks.
 * It provides methods to filter, transform, perform actions, and add tasks.
 */
public class TaskManager {
    private List<Task> tasks;

    /**
     * Initializes a new TaskManager with a predefined list of tasks.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
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
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Filters tasks based on the provided criteria.
     *
     * @param criteria The condition to filter tasks.
     * @return A list of tasks that match the predicate.
     */
    public List<Task> fiterTasks(Predicate<Task> criteria) {
        return tasks.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }


    /**
     * Transforms the descriptions of all tasks using the provided function.
     *
     * @param description The function to apply to each task's description.
     */
    public void transformTaskDescription(Function<String, String> description){
        tasks.forEach(task -> task.setDescription(description.apply(task.getDescription())));

    }

}

