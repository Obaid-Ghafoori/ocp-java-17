package chapter_07.classes.bank_app;

public final class DigitalWalletPayment implements Payment {
    private String walletId;
    private final String securityToken;

    public DigitalWalletPayment(String walletId, String securityToken) {
        this.walletId = walletId;
        this.securityToken = securityToken;
    }
    @Override
    public boolean validate() {
        return walletId != null;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing digital wallet payment of €" + amount);
    }
}
