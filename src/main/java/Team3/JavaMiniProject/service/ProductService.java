package Team3.JavaMiniProject.service;

import Team3.JavaMiniProject.ACMEappMain;
import Team3.JavaMiniProject.model.Customer;
import Team3.JavaMiniProject.model.Product;
import Team3.JavaMiniProject.repository.CRUDRepository;
import Team3.JavaMiniProject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class ProductService implements CRUDRepository<Product, Long> {


    private final ProductRepository productRepository;
    private static final Logger logger = LogManager.getLogger(ACMEappMain.class);

    @Override
    public Product create(Product product){
        logger.info("Creating Product");
        Product readyProduct = productRepository.create(product);
        return readyProduct;
    }

    @Override
    public List<Product> createAll(Product... products){
        logger.info("Creating all products");
        List<Product> readyProducts = productRepository.createAll(products);
        return readyProducts;
    }

    @Override
    public boolean update(Product product){
        logger.info("Updating Product");
        if(product.getId() > 0){
            productRepository.update(product);
        }
        return false;
    }

    @Override
    public void delete(Product product){
        logger.info("Deleting Product");
        productRepository.delete(product);
    }

    public List<Product> findAll(){
        logger.info("Finding all Product");
        List<Product> allSavedProduct = productRepository.findAll();
        return allSavedProduct;
    }

    @Override
    public Optional<Product> findByID(Long id){
        logger.info("Searching Product by ID");
        Optional<Product> savedOptionalProduct = productRepository.findByID(id);
        if (savedOptionalProduct.isPresent()){
            Product savedProduct = savedOptionalProduct.get();
        }
        return savedOptionalProduct;
    }
}
