package Team3.JavaMiniProject.model;

import java.math.BigDecimal;

public class Product {

    private int productID;
    private String productName;
    private BigDecimal productPrice;
    private String productInfo;

    public Product(){

    }

    public Product(int productID, String productName, BigDecimal productPrice, String productInfo) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }
}
