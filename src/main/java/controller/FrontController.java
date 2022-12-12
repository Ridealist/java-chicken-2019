package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Payment;
import domain.Table;
import domain.TableRepository;
import domain.status.MainOption;
import domain.status.PaymentType;
import java.util.EnumMap;
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
        OutputView.printTables(TableRepository.tables());
        final Table table = InputView.inputTableNumber();
        OutputView.printMenus(MenuRepository.menus());

        Menu menu = InputView.readMenu();
        int orderQuantity = InputView.readMenuQuantity();
        table.addOrder(menu, orderQuantity);
    }

    private void payment() {
        OutputView.printTables(TableRepository.tables());
        final Table table = InputView.inputTableNumber();
        OutputView.printOrderHistory(table.getOrderHistory());
        Payment payment = new Payment(table);

        OutputView.printStartPayment(table.getNumber());
        PaymentType paymentType = InputView.readPaymentType();
        OutputView.printTotalPrice(payment.getFinalDiscountPrice(paymentType));

        table.clearTable();
    }

}
