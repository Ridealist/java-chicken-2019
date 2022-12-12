package controller;

import domain.status.MainOption;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class FrontController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MainOption, Supplier<MainOption>> gameGuide;

    public FrontController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public MainOption progress(MainOption mainOption) {
        try {
            return gameGuide.get(mainOption).get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return mainOption;
        }
    }

    private MainOption orderRegistration() {
        return null;
    }

    private MainOption payment() {
        return null;
    }

    private MainOption exitApplication() {
        return null;
    }

}
