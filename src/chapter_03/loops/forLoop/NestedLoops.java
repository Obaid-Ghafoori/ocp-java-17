package chapter_03.loops.forLoop;

import java.sql.SQLOutput;

public class NestedLoops {
    static int[][] complexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};

    public static void main(String[] args) {
        for (int[] simpleArray : complexArray) { // outer loop execute three times
            for (int i = 0; i < simpleArray.length; i++) { // inner loop execute four times
                System.out.print(simpleArray[i] + "\t");
            }
            System.out.println();
        }

        int hungryHippopotamus = 8;
        while (hungryHippopotamus > 0) {
            do { // guarantee to execute even hungryHippopotamus not greater than 5
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus > 5);
            hungryHippopotamus --;
            System.out.print(hungryHippopotamus + ", ");
        }

        System.out.println();

        /**
         * Adding optional labels
         */
      OUTER_LOOP:  for (int[] simpleArray : complexArray) { // outer loop execute three times
          INNER_LOOP: for (int i = 0; i < simpleArray.length; i++) { // inner loop execute four times
                System.out.print(simpleArray[i] + "\t");
            }
            System.out.println();
        }

    }
}
