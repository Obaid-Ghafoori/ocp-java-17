package chapter_07.chapter_07.JavaInterface;

import java.util.regex.Pattern;

public class AppRunner {
    private String description;

    public static void main(String[] args) throws InterruptedException {
        var iPhone = new Smartphone();

        iPhone.trurnOn();
        Thread.sleep(120);
        iPhone.turnOff();
        System.out.println(getInterfaceDescription());
        System.out.println(getInterfaceRules());


    }

    private static String getInterfaceDescription() {
        Pattern indentation = Pattern.compile("\n\t\t\t");

        return String.format("""
                                    
                Definition: An interface in Java is a reference type, similar to a class, that can contain only constants, %smethod signatures, default methods, static methods, and nested types. Interfaces cannot contain %sinstance fields or constructors.
                                 
                Purpose: \tInterfaces are used to specify a set of methods that a class must implement, %spromoting a form of multiple inheritance and providing a way to achieve abstraction.
                """, indentation, indentation, indentation);
    }


    private static String getInterfaceRules() {
        Pattern indentation = Pattern.compile("\n\t\t\t");

        return String.format("""
                  RULES
                  1. Interface Access Modifiers:
                  %spublic: The interface is accessible from any other class.
                  %sdefault (package-private): The interface is accessible only within its own package.                  
                """, indentation, indentation);
    }
}
