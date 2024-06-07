package chapter_03.loops.while_loop;

public class AlgorithmicLoop {
    public static void main(String[] args) {
        findGcd(56, 98);
        System.out.println("");
        generateFibonacciSequence(20);
        System.out.println("");
        countNumberOfVowel("Welcome to the Oracle Java 17 certification course");


    }

    /**
     Scenario 1: Find the Greatest Common Divisor (GCD) of Two Numbers
     Objective: Implement an algorithm to find the greatest common divisor (GCD) of two numbers using the Euclidean algorithm.
     * @param a given integral number
     * @param b given integral number
     Details:
     The GCD of two integers is the largest integer that divides both of them without leaving a remainder.
     Use the Euclidean algorithm: gcd(a, b) = gcd(b, a % b) until b becomes 0. At this point, a will be the GCD.
     */

    private static void findGcd(int a, int b) {
        while (b != 0){
            int temp = b; //store b value in the temp
            b = a % b; // gcd(b, a % b)
            a = temp;
        }
        System.out.println("GCD -> " + a);
    }

    /**
     * Scenario 2: Generate Fibonacci Sequence Up to N Terms
     * Objective: Generate the first N terms of the Fibonacci sequence.
     *
     * Details:
     *
     * The Fibonacci sequence is a series of numbers where the next number is found by adding the two numbers before it.
     * The sequence starts with 0 and 1. The next numbers are 0, 1, 1, 2, 3, 5, 8, ....
     */

    private static void generateFibonacciSequence(int sequence) {
        int c = 0, d =1; // the first two terms
        int count = 2; // since the first two terms already known

        System.out.print("\nFibonacci Sequence: " + c + " " + d);

        while (count < sequence){
            int nextSum = c + d;
            System.out.print(" " + nextSum);
            c=d;
            d = nextSum;
            count++;
        }
    }

    /**
     * Scenario 3: Count the Number of Vowels in a String
     * Objective: Count the number of vowels (a, e, index, o, u) in a given string.
     *
     * Details:
     *
     * Traverse each character in the string and check if it is a vowel.
     * Keep a count of the number of vowels encountered.
     */
    private static void countNumberOfVowel(String message) {
        message.toLowerCase();
        var vowelCount = 0;
        var index = 0;

        while (index < message.length()){
            var letter = message.charAt(index);
            if(letter =='a' || letter =='e' ||letter =='i' ||letter =='o' ||letter =='u' ){
                vowelCount++;
            }
            index++;
        }

        System.out.println("Number of vowels: " + vowelCount + " in the given message -> " + message);
    }
}
