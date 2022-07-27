package Team3.JavaMiniProject.Repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    List<T> findAll() ;

    Optional<T> findByID(ID id)  ;

    boolean delete(T t)  ;

    T create(T t) ;

    List<T> createAll(T... ts) ;

    boolean update(T t);
}
