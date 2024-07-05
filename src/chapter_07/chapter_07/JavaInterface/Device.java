package chapter_07.chapter_07.JavaInterface;

public interface Device {
    void trurnOn();
    void turnOff();

    /**
     * this method in an interface that have a body. This methods can be optionally overridden by implementing classes.
     * if not the default it will print the default message.
     */
    default void reset() {
        System.out.println("Device is resetting...");
    }
}
