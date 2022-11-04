package eric.local.org.ee9.repositories.impl;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.repositories.CrudRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CategoryRepositoryImpl implements CrudRepository<Category> {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Category> listAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void save(Category category) {
        if (category.getId() != null && category.getId() > 0) {
            entityManager.merge(category);
        } else {
            entityManager.persist(category);
        }
    }

    @Override
    public void delete(Long id) {
        Category category = findById(id);
        entityManager.remove(category);
    }
}
