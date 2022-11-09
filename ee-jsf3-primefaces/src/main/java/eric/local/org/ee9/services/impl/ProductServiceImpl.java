package eric.local.org.ee9.services.impl;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.entities.Product;
import eric.local.org.ee9.repositories.CrudRepository;
import eric.local.org.ee9.repositories.ProductRepository;
import eric.local.org.ee9.services.ProductService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CrudRepository<Category> categoryRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.listAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productRepository.findById(id));
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.listAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return Optional.ofNullable(categoryRepository.findById(id));
    }

    @Override
    public List<Product> listByName(String name) {
        return productRepository.listByName(name);
    }

}
