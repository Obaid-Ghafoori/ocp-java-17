package chapter_07.classes.bank_app;

public non-sealed class InternationalBankTransfer extends BankTransferPayment {
    private final String swiftCode;
    public InternationalBankTransfer(String accountNumber, String bankCode, String swiftCode) {
        super(accountNumber, bankCode);
        this.swiftCode = swiftCode;
    }
}
