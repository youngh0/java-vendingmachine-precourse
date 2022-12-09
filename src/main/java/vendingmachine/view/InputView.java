package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.ProductPrice;
import vendingmachine.domain.ProductQuantity;
import vendingmachine.domain.ProductsInfo;
import vendingmachine.domain.VendingMachineMoney;

public class InputView {
    public VendingMachineMoney readVendingMachineMoney() {
        return new VendingMachineMoney(Console.readLine());
    }

    public ProductsInfo readProducts() {
        String products = Console.readLine();
        ProductsInfo productsInfo = new ProductsInfo(new ProductPrice(), new ProductQuantity());
        productsInfo.initProductInfo(products);
        return productsInfo;
    }

    public String readProductName() {
        return Console.readLine();
    }
}
