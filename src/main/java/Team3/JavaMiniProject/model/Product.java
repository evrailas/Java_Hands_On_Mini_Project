package Team3.JavaMiniProject.model;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@SuperBuilder
public class Product extends BaseModel {

    private String productName;
    private BigDecimal productPrice;
    private String productInfo;


    public Product(long id, String productName, BigDecimal productPrice, String productInfo) {
        super(id);
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }
}
