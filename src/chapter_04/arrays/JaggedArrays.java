package chapter_04.arrays;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

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
int a =Math.min(5,2);
        long t = Math.round(5.5);
        var doubles = new double[]{t,a};

        String s = """
        example""".indent(7);
//        s.stripLeading();
        System.out.println(s.trim());
        System.out.println(s.substring(1,9));

        System.out.println(Instant.now());

        var arr = new String[] {"PIG", "pig","123"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,"Pippa"));
        var sb = new StringBuilder("Java");
       // sb.reverse();
        sb.append("vaJ$").delete(0,3).deleteCharAt(sb.length()-1);
        System.out.println(sb);

        String str = "12345";
        var sbl = new StringBuilder("12345"); //12365
//        char c = str.replace("123", "1").charAt(2);
       sbl.replace(2,4, "6").charAt(3);
        System.out.println(sbl);

var datetime =LocalDateTime.now();

        System.out.println(datetime);
        System.out.println(Instant.now());


        var bas = "ewe\nsheep\\t";
        System.out.println(bas.length());
        System.out.println(bas.indent(2).length());
        System.out.println(bas.translateEscapes().length());

    }

    @SneakyThrows
    private static double[][] extractValues(Double s) {
        Field fieldname = s.getClass().getDeclaredField("fieldname");
        fieldname.setAccessible(true);
        return (double[][]) fieldname.get(s);
    }
    @SneakyThrows
    private static void printToFile(String name, double[][] dataValues){
        Path tempFile = Files.createTempFile(name, ".csv");
        System.out.println(tempFile);

        try(FileWriter writer = new FileWriter(tempFile.toFile())){
           for (int row = 0; row < dataValues.length; row++) {
               var line = new StringBuilder();
               for (int col = 0; col < dataValues[row].length; col++) {
                   line.append(dataValues[row][col] + ",");
               }

               writer.append(line.substring(0, line.length() -1));
               // break the line
               writer.append("\n");
           }
       }catch(Exception e){
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
