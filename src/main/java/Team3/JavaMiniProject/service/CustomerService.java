package Team3.JavaMiniProject.service;

import Team3.JavaMiniProject.ACMEappMain;
import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.repository.CRUDRepository;
import Team3.JavaMiniProject.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class CustomerService implements CRUDRepository<Customer, Long> {

    private final CustomerRepository customerRepository;
    private static final Logger logger = LogManager.getLogger(ACMEappMain.class);

    @Override
    public Customer create(Customer customer){
        logger.info("Creating Customer");
        Customer readyCustomer = customerRepository.create(customer);
        return readyCustomer;
    }

    @Override
    public List<Customer> createAll(Customer... customers){
        logger.info("Creating all customers");
        List<Customer> readyCustomers = customerRepository.createAll(customers);
        return readyCustomers;
    }

    @Override
    public boolean update(Customer customer){
        logger.info("Updating Customer");
        if(customer.getId() > 0){
           customerRepository.update(customer);
        }
        return false;
    }

    @Override
    public void delete(Customer customer){
        logger.info("Deleting Customer");
        customerRepository.delete(customer);
    }

    public List<Customer> findAll(){
        logger.info("Finding all Customers");
        List<Customer> allSavedCustomers = customerRepository.findAll();
        return allSavedCustomers;
    }

    @Override
    public Optional<Customer> findByID(Long id){
        logger.info("Searching Customer by ID");
        Optional<Customer> savedOptionalCustomer = customerRepository.findByID(id);
        if (savedOptionalCustomer.isPresent()){
            Customer savedCustomer = savedOptionalCustomer.get();
        }
        return savedOptionalCustomer;
    }
}
