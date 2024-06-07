package chapter_03;


/**
 * Switch expressions were introduced in Java 12 as a preview feature and became a standard feature starting from Java 14.
 * They provide a more concise and expressive way to write switch statements.
 *
 * In traditional switch statements, you can only use constant expressions in the case labels, but switch expressions
 * allow you to use any expression that evaluates to a constant value, such as enums, strings, and integral types.
 */
public class SwitchExpression {
    public static void main(String[] args) {
        int dayOfWeek = 3;
        String dayName = switch (dayOfWeek) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };
        System.out.println("number " + dayOfWeek + ": is a " + dayName + ".");


        // 2nd example
        String weekdayName = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> {
                yield "Weekday";
            }
            case 6, 7 -> {
                yield "Weekend";
            }
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };
        System.out.println("and it is a " + weekdayName + ".");

        // switch expression that returns a value must handle all possible value, for example,
        // what is the value of the badDaysName if dayOfWeek is 6? so one of way would be to add default branch.
        /*
        String badDaysName = switch (dayOfWeek) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";

        };
        */

    }
}
