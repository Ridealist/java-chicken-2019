import controller.FrontController;
import domain.status.MainOption;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        MainOption mainOption = MainOption.INITIALIZE_APPLICATION;
        FrontController frontController = new FrontController(inputView, outputView);

        frontController.service(mainOption);



    }
}
