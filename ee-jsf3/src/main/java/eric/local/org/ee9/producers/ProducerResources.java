package eric.local.org.ee9.producers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;

@ApplicationScoped
public class ProducerResources {

    @Produces
    @RequestScoped
    public FacesContext facesContextBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);

        return facesContext;
    }

}
