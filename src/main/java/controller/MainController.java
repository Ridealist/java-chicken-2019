package controller;

import domain.status.MainOption;
import java.util.EnumMap;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class MainController {
    private final Map<MainOption, Controllable> controllers;

    public MainController() {
        this.controllers = new EnumMap<>(MainOption.class);
        initializeGameGuide();
    }

    private void initializeGameGuide() {
        controllers.put(MainOption.ORDER_REGISTRATION, new OrderRegistrationController());
        controllers.put(MainOption.PAYMENT, new PaymentController());
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
            controllers.get(mainOption).process();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }


}
