package chapter_07.chapter_07.java_interface;

import chapter_07.java_interface.Device;
import chapter_07.java_interface.SmartWatch;
import chapter_07.java_interface.Smartphone;

import java.util.regex.Pattern;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException {
        var iPhone = new Smartphone();

        iPhone.trurnOn();
        Thread.sleep(120);
        System.out.println(String.format("Starting the %s", iPhone.getDeviceType()));
        iPhone.turnOff();
        System.out.println(getInterfaceDescription());
        System.out.println(getInterfaceRules());

        Thread.sleep(130);
        System.out.println("Device is bought for the resell");
        iPhone.reset();

        String status = Device.status("test");
        System.out.println(status);

        var appleWatch = new SmartWatch();
        System.out.println(String.format("This %s has smart features", appleWatch.getDeviceType()));
        appleWatch.smartFeature();

        var wifiSpeed = appleWatch.getLocalWifiSpeed();
        System.out.println(String.format("Local wifi speed is: %d MB", wifiSpeed));


    }

    private static String getInterfaceDescription() {
        Pattern indentation = Pattern.compile("\n\t\t\t");

        return String.format("""
                                    
                Definition: An interface in Java is a reference type, similar to a class, that can contain only constants, %smethod signatures, default methods, static methods, and nested types. Interfaces cannot contain %sinstance fields or constructors.
                                 
                Purpose: \tInterfaces are used to specify a set of methods that a class must implement, %spromoting a form of multiple inheritance and providing a way to achieve abstraction.
                """, indentation, indentation, indentation);
    }


    private static String getInterfaceRules() {
        return """
                RULES
                --------
                   1. Interface Access Modifiers:
                             public: The interface is accessible from any other class.
                             default (package-private): The interface is accessible only within its own package.
                   
                  2. Default Methods:
                             Methods in an interface that have a body. These methods can be overridden by implementing classes.
                             
                  3. Static methods:  
                             Methods in an interface that belong to the interface itself, not to instances of the interface
                             In other words it can be accessible from the implementing class by referencing interface name
                             e.g. in the Smartphone class call status as -> Device.status.
                             
                             static method cannot be marked as final or abstract
                             
                  4. Private Methods:
                             Private methods in an interface that are used internally by default or static methods 
                             and cannot be accessed by implementing classes.
                             
                  5. Inheritance with Interfaces
                             Java resolve the issue of multiple inheritance by inheriting from multiple other interfaces.
                             A static method cannot be inherited and cannot be accessed in a class that implementing the
                             interface, without referencing with interface name.                
                 """;
    }
}
