package chapter_07.classes.bank_app;

public final class DomesticBankTransfer extends BankTransferPayment {
    public DomesticBankTransfer(String accountNumber, String bankCode) {
        super(accountNumber, bankCode);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of €" + amount);

    }
}
