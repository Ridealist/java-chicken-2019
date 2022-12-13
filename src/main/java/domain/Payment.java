package domain;

import java.math.BigDecimal;

public class Payment {
    public static final int DISCOUNT_PRICE = 10000;
    public static final int DISCOUNT_UNIT = 10;
    private final BigDecimal discountPriceByOrder;

    public Payment(Table table) {
        BigDecimal totalPrice = new BigDecimal(String.valueOf(table.totalPrice()));
        BigDecimal discountPriceByChickenCategory = new BigDecimal(String.valueOf(getDiscountNumber(table))).multiply(
                new BigDecimal(String.valueOf(DISCOUNT_PRICE)));
        this.discountPriceByOrder = totalPrice.subtract(discountPriceByChickenCategory);
    }

    private int getDiscountNumber(Table table) {
        return table.orderNumberOfChickenCategory() / DISCOUNT_UNIT;
    }

    public BigDecimal getFinalDiscountPrice(PaymentType paymentType) {
        return discountPriceByOrder.multiply(paymentType.getDiscountRate());
    }


}
