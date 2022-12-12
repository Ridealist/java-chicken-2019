package domain;

import domain.status.PaymentType;

public class Payment {
    public static final int DISCOUNT_PRICE = 10000;
    public static final int DISCOUNT_UNIT = 10;
    private final int discountPriceByOrder;

    public Payment(Table table) {
        int totalPrice = table.totalPrice();
        int discountPriceByChickenCategory = getDiscountNumber(table) * DISCOUNT_PRICE;
        this.discountPriceByOrder = totalPrice - discountPriceByChickenCategory;
    }

    private int getDiscountNumber(Table table) {
        return table.orderNumberOfChickenCategory() / DISCOUNT_UNIT;
    }

    public int getFinalDiscountPrice(PaymentType paymentType) {
        if(paymentType == PaymentType.CASH){
            return (int) (discountPriceByOrder * 0.95);
        }
        return discountPriceByOrder;
    }


}
