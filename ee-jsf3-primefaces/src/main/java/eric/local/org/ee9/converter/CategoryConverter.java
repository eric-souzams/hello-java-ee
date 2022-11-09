package eric.local.org.ee9.converter;

import eric.local.org.ee9.entities.Category;
import eric.local.org.ee9.services.ProductService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@RequestScoped
@Named("categoryConverter")
public class CategoryConverter implements Converter<Category> {

    @Inject
    private ProductService productService;

    @Override
    public Category getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null) {
            return null;
        }

        Optional<Category> category = productService.findCategoryById(Long.valueOf(id));
        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Category category) {
        if (category == null) {
            return "0";
        }

        return category.getId().toString();
    }
}
