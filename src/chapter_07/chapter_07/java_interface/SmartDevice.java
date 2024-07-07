package chapter_07.chapter_07.java_interface;

/**
 * this represents multiple inheritance concept in the java ecosystem.
 * note: an interface can extend multiple other interfaces, but cannot implement
 */
public interface SmartDevice extends Device, Connectivity {
    default void smartFeature() {
        System.out.println("Receiving call on a smart watch");
    }
}
