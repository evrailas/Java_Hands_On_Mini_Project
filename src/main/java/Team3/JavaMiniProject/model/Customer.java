package Team3.JavaMiniProject.model;

import Team3.JavaMiniProject.types.CustomerType;

public class Customer extends BaseModel{

    private String fullName;
    private String address;
    private CustomerType customerType;
    private double customerDiscount;

    public Customer(long id,String fullName, String address, CustomerType customerType) {
        super(id);
        this.fullName = fullName;
        this.address = address;
        this.customerType = customerType;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerType() {
        return String.valueOf(customerType);
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public double getCustomerDiscount() {
        return customerDiscount;
    }

    public void setCustomerDiscount(double customerDiscount) {
        this.customerDiscount = customerDiscount;
    }
}
