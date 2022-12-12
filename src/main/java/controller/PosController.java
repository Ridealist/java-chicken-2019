package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.pay.Pay;
import domain.pay.PayMethod;
import domain.table.Table;
import domain.table.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PosController {

    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void registerOrder() {
        Table table = getTable();
        Menu menu = getMenu();
        Order order = makeOrder(table, menu);
        OrderRepository.add(order);
    }

    public static void payTable() {
        Pay pay = makePay();
        OutputView.printOrderList(pay);
        OutputView.printPay(pay);
        PayMethod payMethod = choosePayMethod();
        OutputView.printFinalCost(pay, payMethod);
        OrderRepository.delete(pay);
    }

    private static Table getTable() {
        try {
            OutputView.printTables(tables);
            return TableRepository.findTableByNumber(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getTable();
        }
    }

    private static Menu getMenu() {
        try {
            OutputView.printMenus(menus);
            return MenuRepository.findMenuByNumber(InputView.inputMenuChoice());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getMenu();
        }
    }

    private static Order makeOrder(Table table, Menu menu) {
        try {
            return new Order(table, menu, InputView.inputMenuAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeOrder(table, menu);
        }
    }

    private static Pay makePay() {
        try {
            Table table = getTable();
            return new Pay(table);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makePay();
        }
    }

    private static PayMethod choosePayMethod() {
        try {
            return PayMethod.getMethodByNumber(InputView.inputPayMethod());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return choosePayMethod();
        }
    }
}
