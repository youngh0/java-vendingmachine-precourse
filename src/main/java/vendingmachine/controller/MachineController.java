package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final Changes changes;
    private final VendingMachine vendingMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController() {
        changes = new Changes();
        vendingMachine = new VendingMachine(changes);
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        // 상품 추가, 투입 금액은 별도의 세팅 객체로 빼는 방법
        VendingMachineMoney vendingMachineMoney = inputView.readVendingMachineMoney();
        vendingMachine.initChangeCoinCount(vendingMachineMoney.getMoney());
        outputView.showInitialChangeCoinInfo(changes);
        ProductsInfo productsInfo = inputView.readProducts();
        PaymentMoney paymentMoney = inputView.readMoney();
        while (productsInfo.isPossibleBuyAnything(paymentMoney.getMoney())) {
            outputView.showInputMoney(paymentMoney);
            buyProduct(productsInfo, paymentMoney);
        }
        outputView.showLastChanges(changes, paymentMoney);
    }

    private void buyProduct(ProductsInfo productsInfo, PaymentMoney paymentMoney) {
        while (true) {
            try {
                vendingMachine.buyProduct(productsInfo, inputView.readProductName(), paymentMoney);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }
}
