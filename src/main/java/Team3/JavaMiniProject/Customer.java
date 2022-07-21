package Team3.JavaMiniProject;

public class Customer {

    private int customerID;
    private String fullName;
    private String address;
    private CustomerType customerType;
    private double customerDiscount;

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

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public double getCustomerDiscount() {
     switch (this.getCustomerType()){
         case B2C -> {
             this.customerDiscount = 0;
             break;
         }
         case B2B -> {
             this.customerDiscount = 20;
             break;
         }
         case B2G -> {
             this.customerDiscount = 50;
         }
     }
        return customerDiscount;
    }
}
