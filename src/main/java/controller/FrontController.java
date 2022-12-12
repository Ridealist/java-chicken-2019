package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.status.MainOption;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class FrontController {
    private final Map<MainOption, Supplier<MainOption>> gameGuide;

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

    public MainOption progress(MainOption mainOption) {
        try {
            return gameGuide.get(mainOption).get();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return mainOption;
        }
    }

    private MainOption orderRegistration() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Menu menu = InputView.readMenu();
        System.out.println(menu);

        return null;
    }

    private MainOption payment() {
        return null;
    }

    private MainOption exitApplication() {
        return null;
    }

}
