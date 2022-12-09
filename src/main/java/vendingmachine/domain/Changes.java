package vendingmachine.domain;

import java.util.EnumMap;

public class Changes {
    private final EnumMap<Coin, Integer> changeCount = new EnumMap<>(Coin.class);

    public void addCoinCount(Coin coin) {
        changeCount.put(coin, changeCount.getOrDefault(coin, 0) + 1);
    }

    public int getChangeCount(Coin coin) {
        return changeCount.getOrDefault(coin, 0);
    }
}
