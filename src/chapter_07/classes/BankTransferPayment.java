package chapter_07.classes;

public sealed class BankTransferPayment implements Payment permits  DomesticBankTransfer, InternationalBankTransfer{
    private String accountNumber;
    private String bankCode;

    public BankTransferPayment(String accountNumber, String bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    @Override
    public boolean validate() {
        return accountNumber != null && bankCode != null;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of €" + amount);

    }
}
