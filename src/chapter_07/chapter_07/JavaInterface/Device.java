package chapter_07.chapter_07.JavaInterface;

public interface Device {
    void trurnOn();
    void turnOff();

    /**
     * this method in an interface that have a body. This methods can be optionally overridden by implementing classes.
     * if not the default it will print the default message.
     */
    default void reset() {
        System.out.println("Device is resetting... ⚙️");
    }

    /**
     * Methods in an interface that belong to the interface itself, not to instances of the interface
     * in other words it can be accessible from the implementing class by referencing interface name
     * e.g. in the Smartphone class call status as -> Device.status
     */

    static void status(String tag){
        String state ="Resetting is successfully finished!\uD83D\uDC4D \n";
        state  += tag == "buy" ? "Device is enqueued for the test" : "Device is ready for the sale";
        System.out.println(state);
    }


}
