package chapter_07.java_interface;


import chapter_07.java_interface.java_enum.DeviceType;

public class Smartphone implements Device {
    private DeviceType deviceType = DeviceType.SMARTPHONE;
    @Override
    public void trurnOn() {
        System.out.println("Smart phone is getting started!");
    }

    @Override
    public void turnOff() {
        System.out.println(deviceType + " is shutting down!");

    }

    @Override
    public DeviceType getDeviceType() {
        return this.deviceType;
    }
}
