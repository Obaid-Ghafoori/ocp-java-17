package chapter_07.chapter_07.JavaInterface;

public interface Connectivity {
    void connectToWifi();

    default int getWifiSpeed() {
        return 100;
    }
}
