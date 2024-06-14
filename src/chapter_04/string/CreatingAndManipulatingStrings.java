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

        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    /**
     * {@link String } object is immutable, everytime appending any other string to the current one instantiates new string object
     * and the previous object become eligible to the garbage collector.
     */
    private static void appendToString() {
        String alpha = "";
        for (char current = 'a'; current <= 'z'; current++) {
            alpha += current;
        }
        System.out.println(alpha);
    }
}
