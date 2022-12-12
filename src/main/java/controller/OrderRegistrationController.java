package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class OrderRegistrationController implements Controllable {
    @Override
    public void process() {
        selectTable().addOrder(selectMenu(), selectMenuQuantity());
    }

    private static int selectMenuQuantity() {
        return InputView.readMenuQuantity();
    }

    private static Menu selectMenu() {
        OutputView.printMenus(MenuRepository.menus());
        return InputView.readMenu();
    }

    private static Table selectTable() {
        OutputView.printTables(TableRepository.tables());
        return InputView.inputTableNumber();
    }
}
