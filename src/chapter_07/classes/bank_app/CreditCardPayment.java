package chapter_07.classes.bank_app;

public final class CreditCardPayment implements Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean validate() {
        return cardNumber != null && expiryDate != null && cvv != null;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of €" + amount);
    }
}
