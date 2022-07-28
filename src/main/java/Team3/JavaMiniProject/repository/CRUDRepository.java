package Team3.JavaMiniProject.repository;

import Team3.JavaMiniProject.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    List<T> findAll() ;

    Optional<T> findByID(ID id)  ;

    void delete(T t)  ;

    Customer create(T t) ;

    List<T> createAll(T... ts) ;

    boolean update(T t);
}
