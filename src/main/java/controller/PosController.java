package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.OrderRepository;
import domain.Pay;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class PosController {

    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void registerOrder() {
        OutputView.printTables(tables);
        Table table = repeat(TableRepository::findMenuByNumber, InputView::inputTableNumber);
        repeatMenuAmount(table);
    }

    public static void pay() {
        OutputView.printTables(tables);
        Table table = repeat(TableRepository::findMenuByNumber, InputView::inputTableNumber);
        Pay pay = new Pay(table);
        OutputView.printOrderList(pay);
        OutputView.printPay(table);
        int payMethod = repeat(Integer::valueOf, InputView::inputPayMethod);
        OutputView.printFinalCost(pay, payMethod);
    }

    private static void repeatMenuAmount(Table table) {
        while (true) {
            try {
                OutputView.printMenus(menus);
                Menu menu = repeat(MenuRepository::findMenuByNumber, InputView::inputMenuChoice);
                int menuAmount = repeat(Integer::valueOf, InputView::inputMenuAmount);
                OrderRepository.save(table, menu, menuAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static <T, R> R repeat(Function<T, R> repository, Supplier<T> inputReader) {
        try {
            return repository.apply(inputReader.get());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return repeat(repository, inputReader);
        }
    }
}
