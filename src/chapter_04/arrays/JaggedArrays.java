package chapter_04.arrays;

import java.sql.SQLOutput;

/**
 * Asymmetric arrays also known as a jagged arrays are arrays of arrays where each "sub-array" can have different lengths.
 * This contrasts with regular multidimensional arrays where each sub-array must have the same length.
 */
public class JaggedArrays {
    public static void main(String[] args) {
        // Step 1: Declare a jagged array with 3 rows
        int[][] jaggedArray = new int[3][];

        // Step 2: Initialize each row with different lengths
        jaggedArray[0] = new int[2]; // Initialize the first row with 2 columns.
        jaggedArray[1] = new int[3]; // Initialize the second row with 3 columns.
        jaggedArray[2] = new int[1]; // Initialize the first row with 1 column.

        // Step 3: Populate the jagged array with values
        jaggedArray[0][0] = 1;
        jaggedArray[0][1] = 2;

        jaggedArray[1][0] = 3;
        jaggedArray[1][1] = 4;
        jaggedArray[1][2] = 5;
        jaggedArray[2][0] = 6;

        // Step 4: Print the jagged array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.println(String.format("%d ", jaggedArray[i][j]));
            }
            System.out.println("");
        }

    }
}
