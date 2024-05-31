package chapter_03;

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
        Object obj = new DaysOfTheWeek("Tuesday");
        if (obj instanceof DaysOfTheWeek day && (day.day().equals("Monday") || day.day().equals("Wednesday") || day.day().equals("Friday"))) {
            System.out.println(day.day() + " is a busy day.");
        } else if (obj instanceof DaysOfTheWeek day && (day.day().equals("Tuesday") || day.day().equals("Thursday"))) {
            System.out.println(day.day().toUpperCase() + " is a meeting day.");
        } else if (obj instanceof DaysOfTheWeek day && (day.day().equals("Saturday") || day.day().equals("Sunday"))) {
            System.out.println(day.day() + " is a weekend.");
        } else if (obj == null) {
            System.out.println("Day is null.");
        } else {
            System.out.println("Unknown type or day.");
        }
    }

    record DaysOfTheWeek(String day) {
    }


}
