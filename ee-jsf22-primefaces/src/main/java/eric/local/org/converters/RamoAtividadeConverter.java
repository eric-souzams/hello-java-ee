package eric.local.org.converters;

import eric.local.org.model.RamoAtividade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;

//@FacesConverter(forClass = RamoAtividade.class)
//@FacesConverter(value = "ramoAtividadeConverter")
public class RamoAtividadeConverter implements Converter {

    private List<RamoAtividade> ramoAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> ramoAtividades) {
        this.ramoAtividades = ramoAtividades;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) return null;

        Long id = Long.parseLong(value);
        for (RamoAtividade ramoAtividade : this.ramoAtividades) {
            if (id.equals(ramoAtividade.getId())) {
                return ramoAtividade;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return null;

        RamoAtividade ramoAtividade = (RamoAtividade) value;

        return ramoAtividade.getId().toString();
    }

}
