package eric.local.org.ee9.controllers;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.entities.Product;
import eric.local.org.ee9.services.ProductService;
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

    @Produces
    @Model
    public Product product() {
        this.product = new Product();

        if (id != null && id > 0) {
            product = productService.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
        }

        return product;
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

    @Produces
    @RequestScoped
    @Named("listing")
    public List<Product> listAll() {
        return productService.listAll();
    }

    public String save() {
        if (product.getId() != null && product.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.edit")));
        } else  {
            facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.create")));
        }

        productService.save(product);

        return "index.xhtml?faces-redirect=true";
    }

    public String edit(Long id) {
        this.id = id;
        return "form.xhtml";
    }

    public String delete(Long id) {
        productService.delete(id);
        facesContext.addMessage(null, new FacesMessage(resourceBundle.getString("product.message.delete")));
        return "index.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
