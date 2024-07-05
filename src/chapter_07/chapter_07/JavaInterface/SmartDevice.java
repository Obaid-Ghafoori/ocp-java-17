package chapter_07.chapter_07.JavaInterface;

/**
 * this represents multiple inheritance concept in the java eco-system.
 * note: an interface can extend multiple other interfaces, but cannot implement
 */
public interface SmartDevice extends Device, Connectivity {
    default void smartFeature(){
        System.out.println("Receiving call on a smart watch");
    };
}
