package Team3.JavaMiniProject.model;

import java.math.BigDecimal;
import java.util.List;

public class OrderItem extends Product {

    private BigDecimal finalPrice;
    private List<Product> list;


    public OrderItem(int productID, String productName, BigDecimal productPrice, String productInfo, BigDecimal finalPrice) {
        super(productID, productName, productPrice, productInfo);
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }
}
