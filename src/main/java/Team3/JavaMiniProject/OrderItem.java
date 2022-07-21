package Team3.JavaMiniProject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class OrderItem extends Product{

    private double finalPrice;
    private List<Product> list1 = new ArrayList<Product>(){};


    public OrderItem(int productID, String productName, double productPrice, String productInfo, double finalPrice) {
        super(productID, productName, productPrice, productInfo);
        this.finalPrice = finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
