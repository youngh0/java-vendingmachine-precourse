package vendingmachine.view;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;
import vendingmachine.domain.PaymentMoney;

public class OutputView {
    public void showInitialChangeCoinInfo(Changes changes) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.printf("%d원 - %d개%n", coin.getAmount(), changes.getChangeCount(coin));
        }
    }

    public void showInputMoney(PaymentMoney money) {
        System.out.printf("투입 금액: %d원%n", money.getMoney());
    }

    public void showLastChanges(Changes changes, PaymentMoney money) {
        System.out.println("잔돈");
        for (Coin coin : Coin.values()) {
            int count = changes.getChangeCount(coin);
            if (count == 0) {
                continue;
            }
            int useCount = calculateMaxCoinCount(coin, count, money);
            System.out.printf("%d원 - %d개%n", coin.getAmount(), useCount);
            if (money.getMoney() <= 0) {
                break;
            }
        }
    }

    private int calculateMaxCoinCount(Coin coin, int count, PaymentMoney money) {
        if (coin.getAmount() * count <= money.getMoney()) {
            money.minusMoney(coin.getAmount() * count);
            return count;
        }
        int maxCount = money.getMoney() / coin.getAmount();
        money.minusMoney(maxCount * coin.getAmount());
        return maxCount;
    }
}
