package domain.status;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessage;

class MainOptionTest {

    @Nested
    class invalidInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"4", "잘못", "5"})
        void 잘못된_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MainOption.from(input))
                    .withMessageStartingWith(ExceptionMessage.NO_MAIN_OPTION.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @Test
        void 정상_입력() {
            Assertions.assertEquals(MainOption.ORDER_REGISTRATION, MainOption.from("1"));
            Assertions.assertEquals(MainOption.PAYMENT, MainOption.from("2"));
            Assertions.assertEquals(MainOption.APPLICATION_EXIT, MainOption.from("3"));
        }
    }
}