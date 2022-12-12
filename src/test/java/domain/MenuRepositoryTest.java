package domain;

import static org.assertj.core.api.Assertions.*;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    @Test
    void 메뉴_번호_올바른_메뉴_반환() {
        Assertions.assertThat(MenuRepository.findMenuByNumber(1))
                .isInstanceOf(Menu.class)
                .satisfies(menu -> {
                    assertThat(menu.getName()).isEqualTo("후라이드");
                });
    }

    @Test
    void 메뉴_번호_올바르지_않으면_에러_던지기() {
        assertThatThrownBy(() -> MenuRepository.findMenuByNumber(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}