package chapter_04.string;


/**
 * The == operator is used to compare:
 *
 * Primitives: Checks if the values are the same.
 * References: Checks if two references point to the same object in memory.
 *
 * equals() Method
 * The equals() method is used to compare the contents of two objects. By default, the equals() method in the Object class
 * checks for reference equality (same as ==). However, many classes override this method to provide content equality (e.g., String, Integer).
 */
public class EqualityInJava {

    /**
     * Key Points to Remember
     *
     * == for Primitives: Directly compares values.
     * == for Objects: Compares references (memory addresses).
     *
     * equals(): Should be used for content comparison. Classes like String, Integer, and custom classes
     * (with overridden equals()) use this for meaningful comparisons.
     *
     *
     * Best Practices
     * Use == for primitive comparisons.
     * Use equals() for object content comparison.
     * Always override equals() and hashCode() together to maintain consistency in collections that rely on these methods (e.g., HashMap, HashSet).
     * @param args
     */
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("John", 25);
        Person p3 = p1;

        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1 == p3); // true
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
}
