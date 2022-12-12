package controller;

import domain.Payment;
import domain.Table;
import domain.TableRepository;
import domain.status.PaymentType;
import view.InputView;
import view.OutputView;

public class PaymentController implements Controllable {

    @Override
    public void process() {
        final Table table = selectTable();
        OutputView.printOrderHistory(table.getOrderHistory());
        Payment payment = new Payment(table);
        OutputView.printStartPayment(table.getNumber());
        PaymentType paymentType = InputView.readPaymentType();
        OutputView.printTotalPrice(payment.getFinalDiscountPrice(paymentType));
        table.clearTable();
    }

    private static Table selectTable() {
        OutputView.printTables(TableRepository.tables());
        return InputView.inputTableNumber();
    }

}
