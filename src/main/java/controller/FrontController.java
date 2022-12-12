package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.status.MainOption;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class FrontController {
    private final Map<MainOption, Runnable> gameGuide;

    public FrontController() {
        this.gameGuide = new EnumMap<>(MainOption.class);
        initializeGameGuide();
    }

    private void initializeGameGuide() {
        gameGuide.put(MainOption.ORDER_REGISTRATION, this::orderRegistration);
        gameGuide.put(MainOption.PAYMENT, this::payment);
        gameGuide.put(MainOption.APPLICATION_EXIT, this::exitApplication);
    }


    public void service() {
        MainOption mainOption;
        do {
            OutputView.printMainScreen();
            mainOption = InputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public void progress(MainOption mainOption) {
        try {
            gameGuide.get(mainOption).run();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void orderRegistration() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final Table table = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Menu menu = InputView.readMenu();
        int orderQuantity = InputView.readMenuQuantity();
        table.addOrder(menu, orderQuantity);
    }

    private void payment() {
    }

    private void exitApplication() {
    }

}
