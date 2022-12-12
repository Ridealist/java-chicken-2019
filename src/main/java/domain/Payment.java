package domain;

public class Payment {
    public static final int DISCOUNT_PRICE = 10000;
    public static final int DISCOUNT_UNIT = 10;
    private final int totalPrice;
    private final int discountPriceByChickenCategory;

    public Payment(Table table) {
        this.totalPrice = table.totalPrice();
        this.discountPriceByChickenCategory = getDiscountNumber(table) * DISCOUNT_PRICE;
        System.out.println(totalPrice);
        System.out.println(discountPriceByChickenCategory);
    }

    private static int getDiscountNumber(Table table) {
        return table.orderNumberOfChickenCategory() / DISCOUNT_UNIT;
    }
}
