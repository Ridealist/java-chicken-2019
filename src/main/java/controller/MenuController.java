package controller;

import domain.order.OrderRepository;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class MenuController {

    private boolean isRun = true;

    public void start() {
        while (isRun) {
            runPosController();
        }
    }

    private void runPosController() {
        OutputView.printMain();
        Command command = repeat(Command::findCommandByNumber, InputView::inputFunctionNumber);
        chooseFunction(command);
    }

    private void chooseFunction(Command command) {
        if (command == Command.REGISTER) {
            PosController.registerOrder();
        }
        if (command == Command.QUIT) {
            isRun = false;
        }
        if (command == Command.PAY) {
            executePay();
        }
    }

    private void executePay() {
        try {
            validateAnyOrderExist();
            PosController.payTable();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void validateAnyOrderExist() {
        if (!OrderRepository.hasAnyOrders()) {
            throw new IllegalArgumentException("등록된 주문이 하나도 없습니다. 주문을 먼저 등록해주세요.");
        }
    }

    private static <T, R> R repeat(Function<T, R> object, Supplier<T> reader) {
        try {
            return object.apply(reader.get());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return repeat(object, reader);
        }
    }
}
