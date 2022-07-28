package Team3.JavaMiniProject.model;

import Team3.JavaMiniProject.types.PaymentMethod;

import java.util.List;

public class Order {

    private int orderID;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    private Customer customer;

    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(int orderID, String deliveryAddress, PaymentMethod paymentMethod, double paymentAmount, Customer customer, List<OrderItem> orderItemList) {
        this.orderID = orderID;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.customer = customer;
        this.orderItemList = orderItemList;
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

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}