package Team3.JavaMiniProject.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    List<T> findAll() ;

    Optional<T> findByID(ID id)  ;

    void delete(T t)  ;

    void create(T t) ;

    List<T> createAll(T... ts) ;

    void update(T t);
}
