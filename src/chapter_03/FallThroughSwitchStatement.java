package chapter_03;

public class FallThroughSwitchStatement {
    public static void main(String[] args) {
        String day = "Friday";

        switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday":
                System.out.println(day + " is a workday.");
                break;
            case "Friday":
                System.out.println(day + " is a study day.");
                break;
            case "Saturday", "Sunday":
                System.out.println(day + " is a weekend.");
                break;
            default:
                System.out.println("Invalid day.");
                break;
        }


        // season of the year
        String month = "April";

        switch (month) {
            case "December", "January", "February":
                System.out.println(month + "is in the Winter");
            case "March", "April", "May":
                System.out.println(month + "is in the Spring");
            case "June", "July", "August":
                System.out.println(month + "is in the Summer");
                break;
            case "September", "October", "November":
                System.out.println(month + "is in the Fall");
            default:
                System.out.println("unknown season");
                break;
        };

    }
}



