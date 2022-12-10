import controller.MenuController;
import controller.PosController;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.start();
    }
}
