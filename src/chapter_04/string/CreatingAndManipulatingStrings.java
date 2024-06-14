package chapter_04.string;

public class CreatingAndManipulatingStrings {
    public static void main(String[] args) {
        appendToString();

        appendToStringBuilder();
    }

    /**
     * When a chaining is used on {@link StringBuilder} unlike {@link String}, it changes its state and
     * return a reference to itself.
     */
    private static void appendToStringBuilder() {
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");

        b = b.append("f").append("g");

        System.out.println(String.format("a= %s and it length is %d",a, a.length()));
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
}
