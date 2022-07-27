package Team3.JavaMiniProject.Models;

public class Product {

    private int productID;
    private String productName;
    private double productPrice;
    private String productInfo;

    public Product(){

    }

    public Product(int productID, String productName, double productPrice, String productInfo) {
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

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }
}
