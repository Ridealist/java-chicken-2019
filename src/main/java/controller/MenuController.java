package controller;

import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class MenuController {

    private boolean isRun = true;

    public void start() {
        while (isRun) {
            run();
        }
    }

    private void run() {
        OutputView.printMain();
        int command = repeat(InputView::inputFunctionNumber);
        if (command == 3) {
            isRun = false;
            return;
        }
        if (command == 1) {
            PosController.registerOrder();
        }
        if (command == 2) {
            PosController.pay();
        }
    }

    private static <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
