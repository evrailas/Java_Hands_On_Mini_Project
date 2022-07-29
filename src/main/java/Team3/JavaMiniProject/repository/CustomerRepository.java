package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.model.DataSource;
import Team3.JavaMiniProject.types.CustomerType;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class CustomerRepository implements CRUDRepository<Customer, Long> {
    private static final Logger logger = LogManager.getLogger(CustomerRepository.class);

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("find.all.customers"));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                customers.add(Customer.builder().id(result.getLong("id"))
                        .fullName(result.getString("fullName"))
                        .address(result.getString("address"))
                        .customerType(CustomerType.valueOf(result.getString("customerType"))).build());
                logger.info(String.valueOf(result.getInt("id")), result.getString("fullName"),
                        result.getString("address"), CustomerType.valueOf(result.getString("customerType")));

            }
        } catch (SQLException ex) {
            logger.error("Error while getting customers", ex);
        }
        return customers;
    }

    @Override
    public boolean update(final Customer customer) {
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("update.one.customer"));
            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, String.valueOf(customer.getCustomerType()));
            int row = statement.executeUpdate();

            if (row > 0) {
                logger.info("A customer has been updated successfully.");
            }
        } catch (SQLException ex) {
            logger.error("Error while getting customers {}", ex);
        }
        return false;
    }

    @Override
    public Customer create(Customer customer) {
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("create.one.customer"));
            int row = statement.executeUpdate();
            if (row > 0) {
                logger.info("The customer has been created successfully.");
            }
        } catch (SQLException ex) {
            logger.error("Error while creating customers", ex);
        }
        return customer;
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
            logger.error("Error while deleting customer {}", ex);
        }
    }

    @Override
    public List<Customer> createAll(Customer... customers) {
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("create.all.customer"));
            logger.info("{} Customers will be added", customers.length);
            for (Customer customer : customers) {
                statement.setString(1, customer.getFullName());
                statement.setString(2, customer.getAddress());
                statement.setString(3, String.valueOf(customer.getCustomerType()));
            }
            statement.addBatch();
            return Arrays.asList(customers);
        } catch (SQLException ex) {
            logger.error("Error while creating customers", ex);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Customer> findByID(Long aLong) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLrepository.get("find.id.customer"))) {
            logger.debug("Finding Customer with ID={}", aLong);
            statement.setLong(1, aLong);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return Optional.of(Customer.builder().id(result.getLong("id"))
                        .fullName(result.getString("fullName"))
                        .address(result.getString("address"))
                        .customerType(CustomerType.valueOf(result.getString("productInfo"))).build());

            } else {
                return Optional.empty();
            }
        } catch (SQLException exception) {
            logger.error("Error while getting products{}", exception);
        }
        return Optional.empty();
    }
}
