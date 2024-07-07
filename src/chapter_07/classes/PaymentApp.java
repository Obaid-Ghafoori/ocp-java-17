package chapter_07.classes;

import chapter_07.classes.bank_app.*;
import chapter_07.classes.bank_app.model.BankCustomer;
import chapter_07.classes.bank_app.model.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        showCustomerTransactionDetails();

        getDescription(creditCardPayment);
    }

    private static void showCustomerTransactionDetails() {
        var customer = new BankCustomer("CUST001", "John Doe", "john.doe@example.com", LocalDate.now());

        String transactionInfo = String.format("\n\tCustomer ID: %s \n\tFull Name: %s \n\tEmail: %s \n\tRegistration Date: %s\n", customer.customerId(), customer.fullName(), customer.email(), customer.registrationDate());
        System.out.println("|--------------------------------- CUSTOMER TRANSACTION DETAILS ---------------------------------|");
        System.out.println(transactionInfo);

        var transaction = new Transaction("TXN001", 100.0, LocalDateTime.now());
        System.out.println("Transaction: " + transaction + "\n");
        System.out.println("|--------------------------------- CUSTOMER TRANSACTION DETAILS END -----------------------------|\n");
    }

    private static void processPayment(Payment payment, double amount) {
        if (payment.validate()) {
            payment.processPayment(amount);
        } else {
            System.out.println("Invalid payment details.");
        }
    }

    private static void getDescription(Payment payment) {
        payment.getNotes();
    }
}
