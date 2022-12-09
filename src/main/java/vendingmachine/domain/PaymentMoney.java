package vendingmachine.domain;

public class PaymentMoney {
    private int money;

    public PaymentMoney(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public void minusMoney(int paymentAmount) {
        money -= paymentAmount;
    }

    public int getMoney() {
        return money;
    }

    private void validate(String money) {
        if (money.endsWith("0")) {
            return;
        }
        throw new IllegalArgumentException("10원 단위로 입력");
    }
}
