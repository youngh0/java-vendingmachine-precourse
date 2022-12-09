package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private final Changes changes;
    List<Integer> coins = new ArrayList<>();

    public VendingMachine(Changes changes) {
        this.changes = changes;
        Arrays.stream(Coin.values())
                .forEach(coin -> coins.add(coin.getAmount()));
    }

    public void initChangeCoinCount(int money) {
        while (money > 0) {
            money -= progressAddCoinCount(money);
        }
    }

    public void buyProduct(ProductsInfo productsInfo, String productName, PaymentMoney money) {
        productsInfo.buyProduct(productName, money);
    }

    private int progressAddCoinCount(int money) {
        int coinAmount = Randoms.pickNumberInList(coins);
        if (Coin.isBiggerThanCoin(money,Coin.of(coinAmount))) {
            changes.addCoinCount(Coin.of(coinAmount));
            return coinAmount;
        }
        return 0;
    }
}
