package Team3.JavaMiniProject;
import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.model.DataSource;
import Team3.JavaMiniProject.model.Order;
import Team3.JavaMiniProject.model.Product;
import Team3.JavaMiniProject.model.Wallet;
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

    }

    public void calculatePrice(){

    }

    public void dbStart() {
        logger.info("Starting database, checking if tables will be created.");
        dropAllTables();
        initializeAllTables();
        populateTables();
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


        customerService.create(Customer.builder().fullName("Ivan Moody").address("Athens 1").customerType(CustomerType.B2G).build());
    }
    private static List<Customer> customerCreation(){

        List<Customer> costumers=List.of(
                Customer.builder().fullName("Jason Hook").address("Athens 2").customerType(CustomerType.B2C).build(),
                Customer.builder().fullName("Chris Kael").address("Athens 3").customerType(CustomerType.B2G).build(),
                Customer.builder().fullName("Cory Tailor").address("Athens 4").customerType(CustomerType.B2C).build(),
                Customer.builder().fullName("Spyros Moody").address("Athens 6").customerType(CustomerType.B2C).build(),
                Customer.builder().fullName("Evangelos Moody").address("Athens 7").customerType(CustomerType.B2G).build(),
                Customer.builder().fullName("Dimos Moody").address("Athens 8").customerType(CustomerType.B2C).build(),
                Customer.builder().fullName("Ivan Moody").address("Athens 10").customerType(CustomerType.B2G).build(),
                Customer.builder().fullName("Ivan Moody").address("Athens 11").customerType(CustomerType.B2C).build(),
                Customer.builder().fullName("Ivan Moody").address("Athens 12").customerType(CustomerType.B2G).build(),
                Customer.builder().fullName("Ivan Moody").address("Athens 13").customerType(CustomerType.B2G).build(),
                Customer.builder().fullName("Ivan Moody").address("Athens 14").customerType(CustomerType.B2C).build()

        );
        return costumers;
    }
}
