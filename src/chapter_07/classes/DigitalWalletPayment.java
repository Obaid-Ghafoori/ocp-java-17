package chapter_07.classes;

public final class DigitalWalletPayment implements Payment {
    private String walletId;

    public DigitalWalletPayment(String walletId) {
        this.walletId = walletId;
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
