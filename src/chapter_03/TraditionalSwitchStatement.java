package chapter_03;

/**
 * In traditional switch statements, the types supported are:
 *
 * Primitive Integral and its wrapper Types:
 *
 * byte, short, char, int and Byte, Short, Character, and Integer.
 * long, float, and double are not supported.
 */
public class TraditionalSwitchStatement {
    public static void main(String[] args) {
        String day = "Tuesday";

        switch (day) {
            case "Monday":
                System.out.println("Start of the work week.");
                break;
            case "Tuesday":
                System.out.println("Second day of the work week.");
                break;
            case "Wednesday":
                System.out.println("Midweek.");
                break;
            case "Thursday":
                System.out.println("Almost the weekend.");
                break;
            case "Friday":
                System.out.println("Last day of the work week.");
                break;
            case "Saturday":
                System.out.println("Weekend has started.");
                break;
            case "Sunday":
                System.out.println("Weekend day.");
                break;
            default:
                System.out.println("Invalid day.");
                break;
        }
    }
}
