package Team3.JavaMiniProject.model;

import Team3.JavaMiniProject.types.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public class Order extends BaseModel {

    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;

    private Customer customer;

    private List<OrderItem> orderItemList;


    public Order(long id, String deliveryAddress, PaymentMethod paymentMethod, BigDecimal paymentAmount, Customer customer, List<OrderItem> orderItemList) {
        super(id);
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.customer = customer;
        this.orderItemList = orderItemList;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
