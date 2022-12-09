package vendingmachine.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest extends NsTest {

    @Test
    void initChangeCoinCount() {
        assertRandomNumberInListTest(
                () -> {
                    Changes changes = new Changes();
                    VendingMachine vendingMachine = new VendingMachine(changes);
                    vendingMachine.initChangeCoinCount(410);
                    run();
                    assertThat(changes.getChangeCount(Coin.COIN_100)).isEqualTo(3);
                    assertThat(changes.getChangeCount(Coin.COIN_50)).isEqualTo(0);
                    assertThat(changes.getChangeCount(Coin.COIN_10)).isEqualTo(1);
                },
                100, 100, 100, 100, 50,10
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}