package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {

    public static final int FRIED_CHICKEN_INDEX = 0;
    public static final int ORDER_QUANTITY = 10;
    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table(1);
    }

    @Test
    void 테이블_비교_테스트() {
        Assertions.assertTrue(table.isSame("1"));

    }

    @Test
    void 주문_들어감_테스트() {
        Assertions.assertFalse(table.hasOrder());
        orderTenFriedChicken();
        Assertions.assertTrue(table.hasOrder());
    }

    @Test
    void 주문_금액_테스트() {
        Menu friedChicken = MenuRepository.menus().get(FRIED_CHICKEN_INDEX);
        int friedChickenPrice = friedChicken.getPrice();
        table.addOrder(friedChicken, ORDER_QUANTITY);
        Assertions.assertEquals(friedChickenPrice * ORDER_QUANTITY, table.totalPrice());

    }

    @Test
    void 치킨_카테고리_주문_개수_테스트() {
        orderTenFriedChicken();
        Assertions.assertEquals(ORDER_QUANTITY, table.orderNumberOfChickenCategory());
    }

    @Test
    void 테이블_정리_테스트() {
        orderTenFriedChicken();
        Assertions.assertTrue(table.hasOrder());
        table.clearTable();
        Assertions.assertFalse(table.hasOrder());
    }

    private void orderTenFriedChicken() {
        Menu friedChicken = MenuRepository.menus().get(FRIED_CHICKEN_INDEX);
        table.addOrder(friedChicken, ORDER_QUANTITY);
    }
}