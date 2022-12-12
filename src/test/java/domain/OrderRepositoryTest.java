package domain;

import static org.assertj.core.api.Assertions.*;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderRepositoryTest {

    static final Table table = TableRepository.findTableByNumber(1);
    static final Menu menuOne = MenuRepository.findMenuByNumber(1);
    static final Menu menuTwo = MenuRepository.findMenuByNumber(2);
    static final Menu menuTwentyOne = MenuRepository.findMenuByNumber(21);


    @BeforeAll
    static void init() {
        OrderRepository.add(new Order(table, menuOne, 5));
        OrderRepository.add(new Order(table, menuTwo, 6));
        OrderRepository.add(new Order(table, menuOne, 11));
        OrderRepository.add(new Order(table, menuTwentyOne, 7));
    }

    @org.junit.jupiter.api.Order(1)
    @Test
    void 테이블_메뉴_전체_주문_수량_추출_테스트() {
        assertThat(OrderRepository.countMenuAmountByTable(table, menuOne))
                .isEqualTo(16);
    }

    @org.junit.jupiter.api.Order(2)
    @Test
    void 테이블_특정_카테고리_메뉴_전체_주문_수량_추출_테스트() {
        assertThat(OrderRepository.countMenuAmountByTableAndCategory(table, Category.CHICKEN))
                .isEqualTo(22);
    }

    @org.junit.jupiter.api.Order(3)
    @Test
    void 테이블_주문_내역_있는_경우_확인_테스트() {
        assertThat(OrderRepository.hasOrdersOnTable(table))
                .isTrue();
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    void 테이블_주문_내역_없는_경우_확인_테스트() {
        assertThat(OrderRepository.hasOrdersOnTable(TableRepository.findTableByNumber(3)))
                .isFalse();
    }

    @org.junit.jupiter.api.Order(5)
    @Test
    void 전체_주문_내역_존재_여부_확인_테스트() {
        // given
        assertThat(OrderRepository.hasAnyOrders())
                .isTrue();
        // when
        OrderRepository.clear();
        //then
        assertThat(OrderRepository.hasAnyOrders())
                .isFalse();
    }
}