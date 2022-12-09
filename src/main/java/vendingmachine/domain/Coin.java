package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    private static final Map<Integer, Coin> coins =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Coin::getAmount, Function.identity())));

    public static Coin of(int amount) {
        return coins.get(amount);
    }

    public int getAmount() {
        return amount;
    }
}
