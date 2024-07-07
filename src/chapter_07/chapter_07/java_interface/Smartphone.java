package chapter_07.chapter_07.java_interface;


public class Smartphone implements Device {
    @Override
    public void trurnOn() {
        System.out.println("Smart phone is getting started!");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart phone is shutting down!");

    }
}
