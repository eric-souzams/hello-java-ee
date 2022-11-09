package eric.local.org.ee9.controllers;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.entities.Product;
import eric.local.org.ee9.services.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.ResourceBundle;

@Model
public class ProductController {

    @Inject
    private ProductService productService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ResourceBundle resourceBundle;

    private Product product;
    private Long id;
    private String searchText;
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = productService.listAll();
        product = new Product();
    }

//    @Produces
//    @Model
    public Product product() {
        this.product = new Product();

        if (id != null && id > 0) {
            product = productService.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
        }

        return product;
    }

    public void closeDialog() {
        product = new Product();
    }

    @Produces
    @Model
    public List<Category> categories() {
        return productService.listAllCategories();
    }

    @Produces
    @Model
    public String title() {
        return "Hello, JSF 3";
    }

//    @Produces
//    @RequestScoped
//    @Named("listing")
//    public List<Product> listAll() {
//        return productService.listAll();
//    }

    public void save() {
        if (product.getId() != null && product.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.edit")));
        } else  {
            facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.create")));
        }

        productService.save(product);
        this.products = productService.listAll();

        product = new Product();

//        return "index.xhtml";
    }

    public void edit(Long id) {
        this.id = id;
        product();
    }

    public void delete(Long id) {
        productService.delete(id);
        facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.delete")));
        this.products = productService.listAll();
    }

    public void search() {
        this.products = productService.listByName(this.searchText);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
