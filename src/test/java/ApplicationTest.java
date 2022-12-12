import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;


class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 정상_실행_테스트() {
        run("1", "1", "1", "10", "2", "1", "2", "3");
        var expected = List.of(
                "## 주문 내역",
                "메뉴 수량 금액",
                "후라이드 10 160000",
                "## 최종 결제할 금액",
                "142500원"
        );
        assertThat(output()).contains(expected);
    }

    @Test
    void 예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "1", "1", "100");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}