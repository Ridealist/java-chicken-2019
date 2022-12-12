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
        OutputView.printTables(TableRepository.tables());
        final Table table = InputView.inputTableNumber();
        OutputView.printMenus(MenuRepository.menus());

        Menu menu = InputView.readMenu();
        int orderQuantity = InputView.readMenuQuantity();
        table.addOrder(menu, orderQuantity);
    }
}
