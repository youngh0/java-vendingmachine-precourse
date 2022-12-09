package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    @DisplayName("금액으로 Coin인스턴스 반환 테스트")
    void coinFindTest() {
        Coin coin = Coin.of(100);
        Assertions.assertThat(coin).isEqualTo(Coin.COIN_100);
    }
}