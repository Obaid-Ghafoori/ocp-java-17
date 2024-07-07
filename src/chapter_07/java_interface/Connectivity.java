package chapter_07.java_interface;

public interface Connectivity {
    void connectToWifi();

    default int getWifiSpeed() {
        return 100;
    }
}
