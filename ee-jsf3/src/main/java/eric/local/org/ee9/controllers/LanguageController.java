package eric.local.org.ee9.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LanguageController implements Serializable {

    private static final long serialVersionUID = 165454854154654L;

    private Locale locale;
    private String language;
    private Map<String, String> languagesAvailable;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        languagesAvailable = new HashMap<>();
        languagesAvailable.put("English", "en");
        languagesAvailable.put("Portuguese (Brazil)", "pt_BR");
    }

    public void select(ValueChangeEvent event) {
        String newValue = event.getNewValue().toString();
        languagesAvailable.values().forEach(v -> {
            if (v.equals(newValue)) {
                this.locale = new Locale(newValue);
                FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
            }
        });
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, String> getLanguagesAvailable() {
        return languagesAvailable;
    }

    public void setLanguagesAvailable(Map<String, String> languagesAvailable) {
        this.languagesAvailable = languagesAvailable;
    }
}
