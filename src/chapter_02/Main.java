package chapter_02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var duck = new Duck();
        duck.setName("YELLOW DUCK");
        duck.setAge(10);
        duck = null;
        // throw is NullPointerException
        /*
        if(duck != null & duck.getAge()<5 ){
            System.out.println("chapter_02.Duck-> "+ duck.getName());
        }
         */

        //Conditional operator throw is NullPointerException
        if (duck != null && duck.getAge() < 5) {
            System.out.println("chapter_02.Duck-> " + duck.getName());
        }


    }
}