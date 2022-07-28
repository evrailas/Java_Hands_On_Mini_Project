package Team3.JavaMiniProject.service;
import Team3.JavaMiniProject.ACMEappMain;
import Team3.JavaMiniProject.model.Order;
import Team3.JavaMiniProject.model.OrderItem;
import Team3.JavaMiniProject.model.Product;
import Team3.JavaMiniProject.repository.CRUDRepository;
import Team3.JavaMiniProject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class OrderService implements CRUDRepository<Order, Long> {

    private final OrderRepository orderRepository;
    private static final Logger logger = LogManager.getLogger(ACMEappMain.class);

    @Override
    public Order create(Order order){
        logger.info("Creating Order");
        Order readyOrder = orderRepository.create(order);
        return readyOrder;
    }

    @Override
    public List<Order> createAll(Order ... orders){
        logger.info("Creating all Orders");
        List<Order> readyOrders = orderRepository.createAll(orders);
        return readyOrders;
    }

    @Override
    public boolean update(Order order){
        logger.info("Updating Order");
        if(order.getId() > 0){
            orderRepository.update(order);
        }
        return false;
    }

    @Override
    public void delete(Order order){
        logger.info("Deleting Order");
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findAll(){
        logger.info("Finding all Order");
        List<Order> allSavedOrders = orderRepository.findAll();
        return allSavedOrders;
    }

    @Override
    public Optional<Order> findByID(Long id){
        logger.info("Searching order by ID");
        Optional<Order> savedOptionalOrder = orderRepository.findByID(id);
        if (savedOptionalOrder.isPresent()){
            Order savedOrder = savedOptionalOrder.get();
        }
        return savedOptionalOrder;
    }
}
