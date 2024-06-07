package chapter_03.loops.while_loop;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        // The following loop is infinite is valid loop
        /*
         for ( ;  ;) {}
         */

        // Use Case: Print numbers from 1 to 10.
        int counter = 1;
        while (counter <= 10) {
            System.out.println(counter + " ");
            counter++;
        }

        // Use Case: Calculate the sum of the digits of a given number.
        int givenNumber = 12345;
        int sum = 0;
        while (givenNumber > 0) {
            int digit = givenNumber % 10; // Extract the last digit
            sum += digit; // Add the digit to the sum
            givenNumber /= 10; // Remove the last digit
        }
        System.out.println("Sum of digits: " + sum);


        // Given an integer, reverse its digits. For example, if the input is 12345, the output should be 54321.
        int originalGivenNumber = 12345;
        int reversedNumber = 0;

        while (originalGivenNumber > 0) {
            int digit = originalGivenNumber % 10; // extract the last digit
            reversedNumber *= 10;
            reversedNumber += digit;
            originalGivenNumber /= 10;
        }

        System.out.println("reversed of digits: " + reversedNumber);

        // Alternative solution, but not as efficient as above because it avoids overhead of string manipulation
        var reversedString = new StringBuilder();
        while (originalGivenNumber > 0) {
            int digit = originalGivenNumber % 10; //Extract the last digit
            reversedString.append(digit);
            originalGivenNumber /= 10;
        }

        System.out.println("Alternative reversed of digits: " + reversedNumber);


        // Use Case: Continuously prompt the user to enter a number between 1 and 10 until they provide a valid input
        var scanner = new Scanner(System.in);
        var input = 0;

        while (input < 1 || input > 10) {
            System.out.println("\nPlease enter number between 1 and 10");
            input = scanner.nextInt();

            if (input < 1 || input > 10) {
                System.out.println("Invalid input, please try again");
            }

        }

        System.out.println("Valid input received -> " + input);
        scanner.close();


    }


}
