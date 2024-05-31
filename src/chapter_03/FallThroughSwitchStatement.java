package chapter_03;

public class FallThroughSwitchStatement {

    public static final int getCookies() {
        return 6;
    }

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
        }
        ;


        /**
         * case apple does not compile because numberOfAnimals is marked as final, the values in each case statement
         * has to be compile-time constant value of the same data type therefore it is not permitted. the same apply for the methods
         * because methods are not evaluated until runtime so they cannot be used as case statement.
         */
        /*
        final int banana = 2;
        int apple = 1;
        int cookies = getCookies();
        final int numberOfAnimals =3;
        switch (numberOfAnimals){
            case banana :
            case apple:
            case cookies:
            case 3*3:
        }
         */


    }


}



