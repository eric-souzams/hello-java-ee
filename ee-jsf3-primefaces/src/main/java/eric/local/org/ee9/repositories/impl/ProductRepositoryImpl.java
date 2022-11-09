package eric.local.org.ee9.repositories.impl;

import eric.local.org.ee9.entities.Product;
import eric.local.org.ee9.repositories.CrudRepository;
import eric.local.org.ee9.repositories.ProductRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class ProductRepositoryImpl implements ProductRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Product> listAll() {
        return entityManager.createQuery("select p from Product p left outer join fetch p.category", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.createQuery("select p from Product p left outer join fetch p.category where p.id=:id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != null && product.getId() > 0) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> listByName(String name) {
        return entityManager.createQuery("select p from Product p left outer join fetch p.category where p.name like :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
