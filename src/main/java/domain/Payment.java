package domain;

public class Payment {
    public static final int DISCOUNT_PRICE = 10000;
    public static final int DISCOUNT_UNIT = 10;
    private final int discountPriceByOrder;

    public Payment(Table table) {
        int totalPrice = table.totalPrice();
        int discountPriceByChickenCategory = getDiscountNumber(table) * DISCOUNT_PRICE;
        this.discountPriceByOrder = totalPrice - discountPriceByChickenCategory;
    }

    private static int getDiscountNumber(Table table) {
        return table.orderNumberOfChickenCategory() / DISCOUNT_UNIT;
    }


}
