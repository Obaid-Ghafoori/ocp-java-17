package chapter_07.java_interface.java_enum;

import chapter_07.java_interface.Device;

/**
 * this enum represent the color
 */
public enum LoggingColor {
    BLUE("\u001B[34m"), // ANSI Blue
    RED("\u001B[31m"),  // ANSI Red
    GREEN("\u001B[32m"), // ANSI Green
    RESET("\u001B[0m"); // ANSI Reset

    private String ansiCode;

    private LoggingColor(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    public String getColorCode() {
        return this.ansiCode;
    }

    public void getNotes(){
        System.out.printf(BLUE.getColorCode()+"|-----------------------------------------------START-----------------------------------------------------------|\n" +RESET.getColorCode());
         String notes = """
                    Enums (short for Enumerations) are a special type of class in Java used to define collections of constants.
                    it provides a way to represent a fixed set of constants, such as the days of the week, directions, etc.
                                  
                    Enums in Java are more powerful than simple enumerations found in other programming languages 
                    since they can have fields, methods, and constructors.
                                  
                    Types and Rules
                        1. Basic Enum:      
                            The simplest form of enum where constants are defined.
                            Constants are implicitly public, static, and final.
                        
                        2. Enum with Fields and Methods:
                            Enums can have fields and methods.
                            Each constant can behave differently with the help of methods.
                       
                        3. Enum with Abstract Methods:
                            Enums can define abstract methods and each constant can provide its own implementation.
                 """;
        System.out.printf(notes+BLUE.getColorCode()+"\n|-----------------------------------------------END-----------------------------------------------------------|" +RESET.getColorCode());

    }
}

