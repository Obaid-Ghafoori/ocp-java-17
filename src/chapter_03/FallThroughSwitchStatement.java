package chapter_03;

public class FallThroughSwitchStatement {
    public static void main(String[] args) {
        String day = "Friday";

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                System.out.println(day + " is a workday.");
                break;
            case "Friday":
                System.out.println(day + " is a study day.");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(day + " is a weekend.");
                break;
            default:
                System.out.println("Invalid day.");
                break;
        }
    }
}
