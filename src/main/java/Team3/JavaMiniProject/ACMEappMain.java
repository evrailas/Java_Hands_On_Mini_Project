package Team3.JavaMiniProject;
import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.model.DataSource;
import Team3.JavaMiniProject.model.Product;
import Team3.JavaMiniProject.repository.CustomerRepository;
import Team3.JavaMiniProject.repository.ProductRepository;
import Team3.JavaMiniProject.repository.SQLrepository;
import Team3.JavaMiniProject.service.CustomerService;
import Team3.JavaMiniProject.service.ProductService;
import Team3.JavaMiniProject.types.CustomerType;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;

@Slf4j
public class ACMEappMain {
    private static final Logger logger = LogManager.getLogger(ACMEappMain.class);

    private static final CustomerService customerService = new CustomerService(new CustomerRepository());
    private static final ProductService productService = new ProductService(new ProductRepository());
    public static void main(String[] args) {

        ACMEappMain eShop = new ACMEappMain();

    }


    public ACMEappMain(){
        dbStart();
        populateTables();
    }

    public void dbStart() {
        logger.info("Starting database, checking if tables will be created.");
        dropAllTables();
        initializeAllTables();
    }

    private static void dropAllTables() {

        List.of(SQLrepository.get("table.orderItem.drop"),
                SQLrepository.get("table.order.drop"),
                SQLrepository.get("table.product.drop"),
                SQLrepository.get("table.customer.drop"))
                .forEach(e-> tablesCheckOut
                        (e, true));

    }

    private static void initializeAllTables() {

        List.of(
                SQLrepository.get("table.customer.create"),
                SQLrepository.get("table.order.create"),
                SQLrepository.get("table.product.create"),
                SQLrepository.get("table.orderItem.create"))
                .forEach(e-> tablesCheckOut
                        (e, false));
    }

    private static void tablesCheckOut(String command, boolean dropTables) {
        try (Connection connection = DataSource.getConnection(); Statement statement = connection.createStatement()) {

            logger.info("{} tables executed as expected.", dropTables ? "Delete" : "Initialize");

        } catch (SQLException ex) {

            if (dropTables) {
                logger.warn("Table to drop not found.");
            } else {
                logger.error("Could not create table cause of error.", ex);
                exit(-1);
            }
        }
    }

    private static void populateTables() {
        try {

            Connection con = DataSource.getConnection();
            PreparedStatement statement = null;
            statement.addBatch(String.valueOf(customerService.createAll()));
            statement.addBatch(String.valueOf(productService.createAll()));


        } catch (SQLException ex) {

        }
    }
}
