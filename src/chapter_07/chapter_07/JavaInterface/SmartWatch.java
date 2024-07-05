package chapter_07.chapter_07.JavaInterface;

public class SmartWatch implements SmartDevice{
    @Override
    public void connectToWifi() {
        System.out.println("⌚SmartWatch is connecting to wifi... \uD83D\uDEDC");
    }

    @Override
    public void trurnOn() {
        System.out.println("⌚SmartWatch is turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("⌚SmartWatch is switching off...");
    }

    /**
     * In Java, when you override a default method from an interface, it is not strictly required to use the
     * @Override annotation, but it is highly recommended. The @Override annotation is used to indicate that
     * a method is intended to override a method declared in a superclass or an interface. It helps to catch
     * errors at compile-time if the method signature does not match the method being overridden.
     */
    @Override
    public void smartFeature(){
        System.out.println("Receiving call on a apple watch ⌚--> \uD83D\uDCDE");
    }

}
