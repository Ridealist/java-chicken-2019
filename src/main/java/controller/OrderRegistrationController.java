package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class OrderRegistrationController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public OrderRegistrationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        selectTable().addOrder(selectMenu(), selectMenuQuantity());
    }

    private int selectMenuQuantity() {
        return inputView.readMenuQuantity();
    }

    private Menu selectMenu() {
        outputView.printMenus(MenuRepository.menus());
        return inputView.readMenu();
    }

    private Table selectTable() {
        outputView.printTables(TableRepository.tables());
        return inputView.inputTableNumber();
    }
}
