package chapter_03;

/**
 * Pattern matching is a powerful feature introduced in Java 16 and enhanced in Java 17.
 * It allows for more concise and readable code by enabling a type test pattern in instanceof expressions and
 * switch expressions. Below are examples covering various corner cases
 */
public class PatternMatchingInstanceOf {
    public static void main(String[] args) {
        Object obj = "Hello, World!";
        /*
        //instead of the following, alternatively we can use Pattern Matching --> see uncommented block
        if (obj instanceof String) {
            String data = (String)obj;
            System.out.println("String length: " + data.length());
        } else if (obj instanceof Integer) {
            Integer dataInt = (Integer)obj;
            System.out.println("Integer value: " + dataInt);
        } else {
            System.out.println("Unknown type");
        }
        */

        if (obj instanceof String data) {
            System.out.println("String length: " + data.length());
        } else if (obj instanceof Integer dataInt) {
            System.out.println("Integer value: " + dataInt);
        } else {
            System.out.println("Unknown type");
        }
    }
}
