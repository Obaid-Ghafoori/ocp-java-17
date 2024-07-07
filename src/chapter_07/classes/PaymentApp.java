package chapter_07.classes;

public class PaymentApp {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment("1234567890123456", "12/25", "123");
        Payment domesticBankTransfer = new DomesticBankTransfer("987654321", "001");
        Payment internationalBankTransfer = new InternationalBankTransfer("987654321", "001", "SWIFT123");
        Payment digitalWalletPayment = new DigitalWalletPayment("wallet123", "tokenABC@DFG$#^%hgfkjgfgdt");

        processPayment(creditCardPayment, 150.0);
        processPayment(domesticBankTransfer, 250.0);
        processPayment(internationalBankTransfer, 500.0);
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
