package controller;

import domain.Payment;
import domain.PaymentType;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class PaymentController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public PaymentController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        final Table table = selectTable();
        outputView.printOrderHistory(table.getOrderHistory());
        Payment payment = new Payment(table);
        outputView.printStartPayment(table.getNumber());
        PaymentType paymentType = inputView.readPaymentType();
        outputView.printTotalPrice(payment.getFinalDiscountPrice(paymentType));
        table.clearTable();
    }

    private Table selectTable() {
        outputView.printTables(TableRepository.tables());
        return inputView.inputTableNumber();
    }

}
