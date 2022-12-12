import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.order.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {
        OrderRepository.clear();
    }

    @Test
    void 주문_등록_작동_테스트() {
        assertSimpleTest(
                () -> {
                    run("1", "1", "1", "1", "3");
                    assertThat(output()).contains(
                            "## 원하는 기능을 선택하세요.",
                            "## 테이블 목록",
                            "┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐",
                            "| 1 || 2 || 3 || 5 || 6 || 8 |",
                            "└ ─ ┘└ ─ ┘└ ─ ┘└ ─ ┘└ ─ ┘└ ─ ┘",
                            "[치킨] 1 - 후라이드 : 16000원",
                            "[음료] 21 - 콜라 : 1000원",
                            "## 등록할 메뉴를 선택하세요.",
                            "## 메뉴의 수량을 입력하세요."
                    );
                }
        );
    }

    @Test
    void 주문_결제_작동_테스트() {
        assertSimpleTest(
                () -> {
                    run("1", "1", "1", "1", "1", "1", "21", "1", "2", "1", "1", "3");
                    assertThat(output()).contains(
                            "## 테이블 목록",
                            "┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐┌ ─ ┐",
                            "| 1 || 2 || 3 || 5 || 6 || 8 |",
                            "└ # ┘└ ─ ┘└ ─ ┘└ ─ ┘└ ─ ┘└ ─ ┘",
                            "## 주문 내역",
                            "메뉴 수량 금액",
                            "후라이드 1 16000",
                            "콜라 1 1000",
                            "## 1번 테이블의 결제를 진행합니다.",
                            "## 신용 카드는 1번. 현금은 2번",
                            "## 최종 결제할 금액",
                            "17000원"
                    );
                }
        );
    }

    @Test
    void 주문_내역_없이_결제_테스트() {
        assertSimpleTest(
                () -> {
                    runException("2");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 주문_내역_없는_테이블_결제_테스트() {
        assertSimpleTest(
                () -> {
                    runException("1", "1", "1", "1", "2", "3");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}