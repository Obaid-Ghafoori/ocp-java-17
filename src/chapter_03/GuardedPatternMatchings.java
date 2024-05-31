package chapter_03;

import java.awt.*;

/**
 * Guarded patterns allow you to add additional conditions (guards) to your pattern matching logic.
 * A guard is a boolean expression that must evaluate to true for the pattern to match.
 * This enables more precise and conditional matching.
 */
public class GuardedPatternMatchings {
    static Object obj = "The of the week";

    /**
     * Useful when you need to refine a match with additional logic, such as checking the length of a string or the range of a number.
     * @param args
     */
    public static void main(String[] args) {
        // example-1
        Object obj = new DaysOfTheWeek("Tuesday");
        if (obj instanceof DaysOfTheWeek day && (day.day().equals("Monday") || day.day().equals("Wednesday") || day.day().equals("Friday"))) {
            System.out.println("\n"+ day.day() + " is a busy day.");
        } else if (obj instanceof DaysOfTheWeek day && (day.day().equals("Tuesday") || day.day().equals("Thursday"))) {
            System.out.println("\n"+ day.day().toUpperCase() + " is a meeting day.");
        } else if (obj instanceof DaysOfTheWeek day && (day.day().equals("Saturday") || day.day().equals("Sunday"))) {
            System.out.println("\n"+ day.day() + " is a weekend.");
        } else if (obj == null) {
            System.out.println("Day is null.");
        } else {
            System.out.println("Unknown type or day.");
        }

        // example-2

        Object object = new Point(1, 2);

        if (object instanceof Point point && (point.x == 1 & point.y<3)) {
            System.out.println("\nPoint with x = 1: " + point);
        } else {
            System.out.println("Unknown type or x != 1");
        }
    }

    record DaysOfTheWeek(String day) {
    }
    record Point(int x, int y){
    }


}
