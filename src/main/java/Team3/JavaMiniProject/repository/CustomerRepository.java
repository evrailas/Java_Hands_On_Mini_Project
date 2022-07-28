package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.model.BaseModel;
import Team3.JavaMiniProject.types.CustomerType;
import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.model.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CustomerRepository implements CRUDRepository<Customer, Long> {
    private static final Logger logger = LogManager.getLogger(CustomerRepository.class);

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {

            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("find.all.customers"));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                customers.add(new Customer(result.getLong("id"),
                        result.getString("fullName"),
                        result.getString("address"),
                        CustomerType.valueOf(result.getString("customerType"))));

                logger.info(String.valueOf(result.getInt("user_id")), result.getString(" "),
                        result.getString(" "), CustomerType.valueOf(result.getString(" ")));

            }


        } catch (SQLException ex) {
            logger.error("Error while getting customers", ex);
        }
        return customers;

    }

    public void create(final Customer customer) {

        try {

            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("create.one.customer"));


            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getCustomerType());

            int row = statement.executeUpdate();

            if (row > 0) {
                logger.info("A new customer has been inserted successfully.");
            }


        } catch (SQLException ex) {
            logger.error("Error while getting customers", ex);
        }
    }

    public void update(Customer customer) {
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("update.one.customer"));

            int row = statement.executeUpdate();

            if (row > 0) {
                logger.info("The customer has been updated successfully.");
            }


        } catch (SQLException ex) {
            logger.error("Error while getting customers", ex);
        }
    }

    public void delete(Customer customer) {
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("delete.one.customer"));


            int row = statement.executeUpdate();

            if (row > 0) {
                logger.info("The customer {} has been deleted successfully.", customer.getId());
            }


        } catch (SQLException ex) {
            logger.error("Error while getting customers", ex);
        }
    }

    public List<Customer> createAll(final Customer... customers) {

        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("create.all.customer"));


            logger.info("{} Customers will be added", customers.length);

            for (Customer customer : customers) {
                statement.setString(1, customer.getFullName());
                statement.setString(2, customer.getAddress());
                statement.setString(3, customer.getCustomerType());

            }

            statement.addBatch();


        } catch (SQLException ex) {
            logger.error("Error while creating customers", ex);
        }

        return Arrays.asList(customers);
    }

    ;

}
