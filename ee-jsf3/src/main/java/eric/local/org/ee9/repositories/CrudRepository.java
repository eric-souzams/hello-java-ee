package eric.local.org.ee9.repositories;


import java.util.List;

public interface CrudRepository<T> {

    List<T> listAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);

}
