package Team3.JavaMiniProject.Models;

import Team3.JavaMiniProject.Models.Product;

import java.util.List;

public class OrderItem extends Product {

    private double finalPrice;
    private List<Product> list;


    public OrderItem(int productID, String productName, double productPrice, String productInfo, double finalPrice) {
        super(productID, productName, productPrice, productInfo);
        this.finalPrice = finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
