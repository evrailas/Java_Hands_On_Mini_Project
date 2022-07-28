package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.model.*;
import Team3.JavaMiniProject.types.PaymentMethod;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.*;

@Slf4j
public class OrderRepository implements  CRUDRepository<Order, Long> {
    @Override
    public List<Order> findAll() {
        List<Order> order= new ArrayList<>();
        try {
            Connection con = DataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLrepository.get("find.all.products"));
            ResultSet result = statement.executeQuery();
            while(result.next()){
                order.add(Order.builder().id(result.getLong("id"))
                        .deliveryAddress(result.getString("deliveryAddress"))
                        .paymentAmount(result.getBigDecimal("paymentAmount"))
                        .paymentMethod(PaymentMethod.valueOf(result.getString("paymentMethod")))
                        .customer((Customer) result.getObject("customer"))
                        .orderItemList((List<OrderItem>) result.getArray("orderItemList")).build());


            }

        }catch (SQLException exception){
            log.error("Error while getting products{}",exception);
        }
        return order;
    }

    @Override
    public Optional<Order> findByID(Long aLong) {
        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLrepository.get("find.id.order"));

            log.debug("Finding order with ID={}", aLong);


            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(Order.builder().id(resultSet.getLong("id"))
                        .deliveryAddress(resultSet.getString("deliveryAddress"))
                        .paymentAmount(resultSet.getBigDecimal("paymentAmount"))
                        .paymentMethod(PaymentMethod.valueOf(resultSet.getString("paymentMethod")))
                        .customer((Customer) resultSet.getObject("customer"))
                        .orderItemList((List<OrderItem>) resultSet.getArray("orderItemList")).build());

            } else {
                return Optional.empty();
            }


        } catch (SQLException exception) {
            log.error("Error while getting order{}", exception);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Order order) {
        try{ Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLrepository.get("delete.order"));

            log.info("Deleting order {}", order);

            preparedStatement.setLong(1, order.getId());

            int result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.error("Could not delete order{}", e);
        }

    }

    @Override
    public Order create(Order order) {
        try{

            Connection con = DataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQLrepository.get("create.order"));
            log.debug("Creating and inserting product{}",order);

            preparedStatement.setLong(1, order.getId());
            preparedStatement.setString(2, order.getDeliveryAddress());
            preparedStatement.setObject(3, order.getCustomer());
            preparedStatement.setBigDecimal(4, order.getPaymentAmount());
            preparedStatement.setObject(5, order.getPaymentMethod());
            preparedStatement.setArray(6, (Array) order.getOrderItemList());

            int row = preparedStatement.executeUpdate();

            if (row > 0){
                log.info("A new product has been inserted successfully.");
            }


        }catch (SQLException ex){
            log.error("Error while getting products{}", ex);
        }

        return null;
    }

    @Override
    public List<Order> createAll(Order... orders) {
        try{

            Connection con = DataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQLrepository.get("create.all.orders"));
            log.debug("Creating a list of products with size{}",orders.length);
            for(Order order:orders){
                preparedStatement.setLong(1, order.getId());
                preparedStatement.setString(2, order.getDeliveryAddress());
                preparedStatement.setObject(3, order.getCustomer());
                preparedStatement.setBigDecimal(4, order.getPaymentAmount());
                preparedStatement.setObject(5, order.getPaymentMethod());
                preparedStatement.setArray(6, (Array) order.getOrderItemList());

            }

            preparedStatement.addBatch();
            return Arrays.asList(orders);




        }catch (SQLException ex){
            log.error("Error while creating orders{}", ex);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean update(Order order) {
        try{

            Connection con = DataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQLrepository.get("update.order"));
            log.debug("Updating order {}",order);

            preparedStatement.setLong(1, order.getId());
            preparedStatement.setString(2, order.getDeliveryAddress());
            preparedStatement.setObject(3, order.getCustomer());
            preparedStatement.setBigDecimal(4, order.getPaymentAmount());
            preparedStatement.setObject(5, order.getPaymentMethod());
            preparedStatement.setArray(6, (Array) order.getOrderItemList());
            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            log.error("Error while creating products{}", ex);
        }

        return false;
    }
}
