package eric.local.org.ee9.repositories;

import eric.local.org.ee9.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product> {

    List<Product> listByName(String name);

}
