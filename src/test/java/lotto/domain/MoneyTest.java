package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1500, 1200, 3300, 7777})
    @DisplayName("로또 구입 금액은 1,000으로 나누어 떨어지지 않으면 예외 처리")
    void lottoSpentMoneydividedBy1000(int inputMoney) {
        Assertions.assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("구입 금액은 1,000원 단위입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 110000, 200000})
    @DisplayName("로또 구입 금액은 1,000보다 작거나 100,000보다 크면 예외 처리")
    void lottoSpentMoneyRange(int inputMoney) {
        Assertions.assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("구입 금액은 1,000원이상 부터 10만원 까지 가능합니다.");
    }
}
