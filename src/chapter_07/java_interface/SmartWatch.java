package chapter_07.java_interface;

import chapter_07.java_interface.java_enum.DeviceType;

public class SmartWatch implements SmartDevice {
    private DeviceType deviceType = DeviceType.SMARTWATCH;

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
     *
     * @Override annotation, but it is highly recommended. The @Override annotation is used to indicate that
     * a method is intended to override a method declared in a superclass or an interface. It helps to catch
     * errors at compile-time if the method signature does not match the method being overridden.
     */
    @Override
    public void smartFeature() {
        System.out.println("Receiving call on a apple watch ⌚--> \uD83D\uDCDE");
    }

    @Override
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    /**
     * calling hidden default method, this kind of operation showcase properties of both Static and Instance method.
     * here we refer the method with interface name first to indicate which method of interface we call then we use
     * super keyword to show we follow the instance of inheritance, but not class (class level = static) inheritance.
     * <p>
     * the override version of interface with optionally annotating with override can be declared as well and equivalent
     * with following implementation.
     *
     * @return the speed of local wifi.
     */
    public int getLocalWifiSpeed() {
        return SmartDevice.super.getWifiSpeed();
    }
}
