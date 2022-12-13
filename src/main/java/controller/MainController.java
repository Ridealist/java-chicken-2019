package controller;

import domain.status.MainOption;
import java.util.EnumMap;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class MainController {
    private final Map<MainOption, Controllable> controllers;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(MainOption.ORDER_REGISTRATION, new OrderRegistrationController(inputView, outputView));
        controllers.put(MainOption.PAYMENT, new PaymentController(inputView, outputView));
        controllers.put(MainOption.APPLICATION_EXIT, new ApplicationExitController(inputView, outputView));
    }


    public void service() {
        MainOption mainOption;
        do {
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public void progress(MainOption mainOption) {
        try {
            controllers.get(mainOption).process();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}
