package chapter_07.classes.bank_app;

public sealed interface Payment permits CreditCardPayment, BankTransferPayment, DigitalWalletPayment {
    boolean validate();
    void processPayment(double amount);

    default void getNotes(){
       final String notes = """
                DESCRIPTION:
                   Sealed classes and interfaces are part of Java's new feature set introduced in JDK 17.
                   They restrict which other classes or interfaces may extend or implement them.
                   This provides more control over the class hierarchy and can enhance the security and maintainability of your code.
                    
                Rules:
                1. Declaration:
                   Use the sealed keyword to declare a sealed class or interface.
                   Following the class declaration, you must use the permits clause to specify the permitted subclasses.
                   
                2. Permitted Subclasses:
                   The subclasses must be explicitly listed in the permits clause.
                   Permitted subclasses must be either final, sealed, or non-sealed.
                                   
                3. A sealed class cannot be instantiated.
                    Permitted subclasses must be defined in the same module or package as the sealed class.
                    Subclasses can further seal themselves or be open to further subclassing (non-sealed).
                """;
        System.out.println("\n"  + notes);
    }
}
