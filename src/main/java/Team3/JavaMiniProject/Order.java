package Team3.JavaMiniProject;

import java.net.PasswordAuthentication;
import java.util.Date;

public class Order {

    private int orderID;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    private Customer customer = new Customer();

    // test about branch stage2

    public Order() {
    }


    public Order(int orderID, String deliveryAddress, PaymentMethod paymentMethod, double paymentAmount) {
        this.orderID = orderID;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

}
