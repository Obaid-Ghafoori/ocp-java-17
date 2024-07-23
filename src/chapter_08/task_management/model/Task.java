package chapter_08.task_management.model;

public class Task {
    private final int id;
    private String description;
    private boolean isCompleted;
    private int priority;

    public Task(int id, String description, boolean isCompleted, int priority) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", description='" + description + "', isCompleted=" + isCompleted + ", priority=" + priority + '}';
    }
}
