package Team3.JavaMiniProject.Models;

import Team3.JavaMiniProject.Enums.CustomerType;

import java.util.List;

public class Customer implements IPay {

    private int customerID;
    private String fullName;
    private String address;
    private CustomerType customerType;
    private double customerDiscount;

    private List<Order> orders;

    public Customer(){

    }

    public Customer(int customerID, String fullName, String address, CustomerType customerType) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.address = address;
        this.customerType = customerType;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerDiscount(){
        if(this.customerType.equals(CustomerType.B2B))
            this.customerDiscount=0.2;
        if(this.customerType.equals(CustomerType.B2G))
            this.customerDiscount=0.5;
        if(this.customerType.equals(CustomerType.B2C))
            this.customerDiscount=0.0;

    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getCustomerType() {
        return String.valueOf(customerType);
    }

}
