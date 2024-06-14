package chapter_04.string;

public class CreatingAndManipulatingStrings {
    public static void main(String[] args) {
        appendToString();
        appendToStringBuilder();
        textEditorWithStringBuilder();
    }

    /**
     * When a chaining is used on {@link StringBuilder} unlike {@link String}, it changes its state and
     * return a reference to itself.
     */
    private static void appendToStringBuilder() {
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");

        b = b.append("f").append("g");

        System.out.println(String.format("a= %s and it length is %d", a, a.length()));
        System.out.println("b= %s and its length is %d".formatted(b, b.length()));
    }

    /**
     * {@link String } object is immutable, everytime appending any other string to the current one instantiates new string object
     * and the previous object become eligible to the garbage collector.
     */
    private static void appendToString() {
        String alpha = "";
        float score = 1;
        for (char current = 'a'; current <= 'z'; current++) {
            score *= 0.73;
            alpha += current;
        }

        System.out.println("Alphabets are %s and the accumulated scores after each iteration is %.4f".formatted(alpha, score));
    }

    private static void textEditorWithStringBuilder() {
        // Step 1: Initialize a StringBuilder with some text
        StringBuilder sb = new StringBuilder("Hello World!");

        // Step 2: Append text
        sb.append(" Welcome to the Text Editor.");

        // Step 3: Insert text at a specific position
        sb.insert(12, "Java ");

        // Step 4: Delete a range of text
        sb.delete(6, 11);

        // Step 5: Replace a portion of text
        sb.replace(0, 5, "Hi");

        // Step 6: Reverse the text
        sb.reverse();

        // Step 7: Extract a substring
        String extractedSubstring = sb.substring(0, 5);

        // Output the results
        System.out.println(String.format("StringBuilder content: %s ", sb.toString()));
        System.out.println(String.format("Extracted substring: %s", extractedSubstring));
    }
}

