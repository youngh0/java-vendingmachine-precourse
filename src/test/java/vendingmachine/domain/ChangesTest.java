package vendingmachine.domain;

import org.junit.jupiter.api.Test;

class ChangesTest {

    @Test
    void addCoinCountTest() {
        Changes changes = new Changes();
        changes.addCoinCount(Coin.COIN_100);
        org.assertj.core.api.Assertions.assertThat(changes.getChangeCount(Coin.COIN_100)).isEqualTo(1);
    }
}