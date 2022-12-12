package domain;

import static org.assertj.core.api.Assertions.*;

import domain.table.Table;
import domain.table.TableRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {

    @Test
    void 테이블_번호_올바른_테이블_반환() {
        Assertions.assertThat(TableRepository.findTableByNumber(1))
                .isInstanceOf(Table.class)
                .satisfies(table -> {
                    assertThat(table.getNumber()).isEqualTo(1);
                });
    }

    @Test
    void 테이블_번호_올바르지_않으면_에러_던지기() {
        assertThatThrownBy(() -> TableRepository.findTableByNumber(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}