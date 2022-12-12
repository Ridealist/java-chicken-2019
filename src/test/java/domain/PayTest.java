package domain;

import static org.assertj.core.api.Assertions.*;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.pay.Pay;
import domain.pay.PayMethod;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PayTest {

    static final Table table = TableRepository.findTableByNumber(1);
    static final Menu menuOne = MenuRepository.findMenuByNumber(1);
    static final Menu menuTwo = MenuRepository.findMenuByNumber(2);
    static final Menu menuTwentyOne = MenuRepository.findMenuByNumber(21);

    static Pay pay;

    @BeforeAll
    static void init() {
        OrderRepository.add(new Order(table, menuOne, 5));
        OrderRepository.add(new Order(table, menuTwo, 6));
        OrderRepository.add(new Order(table, menuOne, 11));
        OrderRepository.add(new Order(table, menuTwentyOne, 7));
        pay = new Pay(table);
    }

    @Test
    void 주문_내역_없는_테이블_결제_에러_던지기() {
        assertThatThrownBy(() -> new Pay(TableRepository.findTableByNumber(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테이블_전체_주문_내역_반환_테스트() {
        assertThat(pay.aggregateMenus())
                .containsOnlyKeys(menuOne, menuTwo, menuTwentyOne)
                .containsValues(16, 6, 7);
    }

    @Test
    void 치킨_메뉴_할인_가격_테스트() {
        assertThat(pay.getDiscountPrice(PayMethod.CREDIT_CARD))
                .isEqualTo((menuOne.getPrice() * 16) + (menuTwo.getPrice() * 6)
                        + (menuTwentyOne.getPrice() * 7) - 20_000);
    }
}