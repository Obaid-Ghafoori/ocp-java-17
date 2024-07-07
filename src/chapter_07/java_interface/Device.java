package chapter_07.java_interface;


import chapter_07.java_interface.java_enum.DeviceType;
import chapter_07.java_interface.java_enum.LogLevel;
import chapter_07.java_interface.java_enum.LoggingColor;


public interface Device {
    void trurnOn();

    void turnOff();

    DeviceType getDeviceType();

    /**
     * this method in an interface that have a body. This methods can be optionally overridden by implementing classes.
     * if not the default it will print the default message.
     */
    default void reset() throws InterruptedException {
        var log = log("Device is enqueued for the reset", LogLevel.INFO);
        System.out.println(log);
        System.out.println(log("Device is resetting... \uD83D\uDCF2 ... ⚙️", LogLevel.INFO));
        Thread.sleep(200);
        System.out.println(log("Resetting is successfully finished!\uD83D\uDC4D", LogLevel.SUCCESS));
        System.out.println("------------------------------------------\n");

    }

    default String log(String message, LogLevel level) {
        LoggingColor color = switch (level) {
            case INFO -> LoggingColor.BLUE;
            case ERROR -> LoggingColor.RED;
            case SUCCESS -> LoggingColor.GREEN;
        };
        return log(message, color);
    }

    /**
     * Methods in an interface that belong to the interface itself, not to instances of the interface
     * in other words it can be accessible from the implementing class by referencing interface name
     * e.g. in the Smartphone class call status as -> Device.status
     *
     * @param tag a given tag
     * @return a status of the device such as for sale or for test.
     */

    static String status(String tag) {
        return switch (tag.toLowerCase()) {
            case "buy" -> "Device is enqueued for the test";
            case "test" -> "Device is ready for the sale";
            default -> throw new IllegalArgumentException("INVALID status is given: --> " + tag);
        };
    }

    /**
     * this method is used internally by default or static methods and cannot be accessed by implementing classes.
     *
     * @param message log message
     * @return a log message
     */
    private String log(String message, LoggingColor color) {
        return String.format("%s, \uD83D\uDCF1 %s %s", color.getColorCode(), message, LoggingColor.RESET.getColorCode());
    }


}
