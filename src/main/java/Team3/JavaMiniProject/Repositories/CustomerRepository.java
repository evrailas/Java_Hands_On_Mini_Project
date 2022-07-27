package Team3.JavaMiniProject.Repositories;

import Team3.JavaMiniProject.Enums.CustomerType;
import Team3.JavaMiniProject.Models.Customer;
import Team3.JavaMiniProject.Models.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CustomerRepository {
    private static final Logger logger = LogManager.getLogger(CustomerRepository.class);

    public List<Customer> selectCustomers() {
        List<Customer> customers = new ArrayList<>();
        try{

            Connection con = DataSource.getConnection();
            String sql = "Select * FROM";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                    customers.add(new Customer(result.getInt("user_id"),result.getString(" "),
                            result.getString(" "), CustomerType.valueOf(result.getString(" "))));

            }


        }catch (SQLException ex){
            logger.error("Error while getting customers", ex);
        }
        return customers;

    }

    private void insertCustomers() {

        try{

            Customer customer = new Customer();
            Connection con = DataSource.getConnection();
            String sql = "INSERT INTO customers (fullName, address, customerType)" + "VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);

           statement.setString(1, customer.getFullName());
           statement.setString(2, customer.getAddress());
           statement.setString(3, customer.getCustomerType());

            int row = statement.executeUpdate();

            if (row > 0){
                logger.info("A new customer has been inserted successfully.");
            }


        }catch (SQLException ex){
            logger.error("Error while getting customers", ex);
        }
    }

    private void updateCustomer(){
        try{
            Connection con = DataSource.getConnection();
            String sql = "UPDATE customers SET address='???' WHERE fullName='????'";
            PreparedStatement statement = con.prepareStatement(sql);

            int row = statement.executeUpdate(sql);

            if (row > 0){
                logger.info("The customer has been updated successfully.");
            }


        }catch (SQLException ex){
            logger.error("Error while getting customers", ex);
        }
    }

    private void deleteCustomer(){
        try{
            Connection con = DataSource.getConnection();
            String sql = "DELETE FROM customers WHERE fullName =?";
            PreparedStatement statement = con.prepareStatement(sql);


            int row = statement.executeUpdate(sql);

            if (row > 0){
                logger.info("The customer has been deleted successfully.");
            }


        }catch (SQLException ex){
            logger.error("Error while getting customers", ex);
        }
    }
}
