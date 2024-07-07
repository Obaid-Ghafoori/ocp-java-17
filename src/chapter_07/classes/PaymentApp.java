package chapter_07.classes;

public class PaymentApp {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment("1234567890123456", "12/25", "123");
        Payment bankTransferPayment = new BankTransferPayment("987654321", "001");
        Payment digitalWalletPayment = new DigitalWalletPayment("wallet123");

        processPayment(creditCardPayment, 150.0);
        processPayment(bankTransferPayment, 250.0);
        processPayment(digitalWalletPayment, 75.0);
        getDescription(creditCardPayment);

    }
    public static void processPayment(Payment payment, double amount) {
        if (payment.validate()) {
            payment.processPayment(amount);
        } else {
            System.out.println("Invalid payment details.");
        }
    }

    public static void getDescription(Payment payment){
        payment.getNotes();
    }
}
