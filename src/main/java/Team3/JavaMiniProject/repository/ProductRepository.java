package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.model.DataSource;
import Team3.JavaMiniProject.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;


@Slf4j
public class ProductRepository implements CRUDRepository<Product,Long> {
    private static final Logger logger = LogManager.getLogger(ProductRepository.class);
    @Override
    public List<Product> findAll() {
        List<Product> products= new ArrayList<>();
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("find.all.products"));
            ResultSet result = statement.executeQuery();
            while(result.next()){
                products.add(new Product(result.getLong("id"),
                        result.getString("productName"),
                        result.getBigDecimal("productPrice"),
                        result.getString("productInfo") ));
            }

        }catch (SQLException exception){
            log.error("Error while getting products{}",exception);
        }
        return products;
    }

    @Override
    public Optional<Product> findByID(Long aLong) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("")) {

            logger.debug("Finding product with ID={}", aLong);


            preparedStatement.setLong(1, aLong);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(Product.builder().id(resultSet.getLong("id"))
                        .productName(resultSet.getString("productName"))
                        .productPrice(resultSet.getBigDecimal("productPrice"))
                        .productInfo(resultSet.getString("productInfo")).build());

            } else {
                return Optional.empty();
            }


        } catch (SQLException exception) {
            logger.error("Error while getting products{}", exception);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Product product) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("")){

            log.debug("Deleting product {}", product);

            preparedStatement.setLong(1, product.getId());

            int result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
           log.error("Could not delete product{}", e);
        }

    }

    @Override
    public void create(Product product) {

        try{

            Connection con = DataSource.getConnection();
            String sql = "INSERT INTO customers (fullName, address, customerType)" + "VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            log.debug("Creating and inserting product{}",product);


            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductPrice().toString());
            statement.setString(3, product.getProductInfo());

            int row = statement.executeUpdate();

            if (row > 0){
                logger.info("A new product has been inserted successfully.");
            }


        }catch (SQLException ex){
            logger.error("Error while getting customers{}", ex);
        }

    }

    @Override
    public List<Product> createAll(Product... products) {

        try{

            Connection con = DataSource.getConnection();
            String sql = "INSERT INTO products (fullName, address, customerType)" + "VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            log.debug("Creating a list of products with size{}",products.length);
            for(Product product:products){
                statement.setString(1, product.getProductName());
                statement.setString(2, product.getProductPrice().toString());
                statement.setString(3, product.getProductInfo());

            }

            statement.executeUpdate();
            return Arrays.asList(products);




        }catch (SQLException ex){
            logger.error("Error while creating products{}", ex);
        }
        return Collections.emptyList();
    }

    @Override
    public void update(Product product) {
        try{

            Connection con = DataSource.getConnection();
            String sql = "INSERT INTO customers (fullName, address, customerType)" + "VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            log.debug("Updating products {}",product);

            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductPrice().toString());
            statement.setString(3, product.getProductInfo());
            statement.executeUpdate();

        }catch (SQLException ex){
            logger.error("Error while creating products{}", ex);
        }

    }
}
