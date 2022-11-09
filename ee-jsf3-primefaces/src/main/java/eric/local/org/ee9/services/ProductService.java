package eric.local.org.ee9.services;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.entities.Product;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductService {

    List<Product> listAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void delete(Long id);
    List<Category> listAllCategories();
    Optional<Category> findCategoryById(Long id);
    List<Product> listByName(String name);

}
