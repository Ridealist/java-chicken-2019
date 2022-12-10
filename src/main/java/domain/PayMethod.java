package domain;

public enum Pay {
    CREDIT_CARD(1, 0.95),
    CASH(2, 1);

    private int choice;
    private double discountPercentage;

    Pay(int choice, double discountPercentage) {
        this.choice = choice;
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPrice(Pay pay, int money) {
        return pay.discountPercentage * money;
    }
}
