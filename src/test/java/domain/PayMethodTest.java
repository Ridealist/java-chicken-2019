package domain;

import static org.assertj.core.api.Assertions.*;

import domain.pay.PayMethod;
import org.junit.jupiter.api.Test;

class PayMethodTest {

    @Test
    void 올바르지_않은_숫자_에러_던지기() {
        assertThatThrownBy(() -> PayMethod.getMethodByNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 현금_결제_할인_테스트() {
        assertThat(PayMethod.CASH.getDiscountPrice(PayMethod.CASH, 10_000))
                .isEqualTo(9_500);
    }

    @Test
    void 카드_결제_할인_없음_테스트() {
        assertThat(PayMethod.CREDIT_CARD.getDiscountPrice(PayMethod.CREDIT_CARD, 10_000))
                .isEqualTo(10_000);
    }
}