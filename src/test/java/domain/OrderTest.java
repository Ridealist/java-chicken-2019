package domain;

import static org.assertj.core.api.Assertions.*;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 테이블_최대_주문_가능_수량_에러_던지기() {
        Table table = TableRepository.findTableByNumber(1);
        Menu menu = MenuRepository.findMenuByNumber(1);
        assertThatThrownBy(() -> new Order(table, menu, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 합계_주문_최대_주문_가능_수량_에러_던지기() {
        Table table = TableRepository.findTableByNumber(1);
        Menu menu = MenuRepository.findMenuByNumber(1);
        Order order = new Order(table, menu, 50);
        OrderRepository.add(order);
        assertThatThrownBy(() -> new Order(table, menu, 50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}