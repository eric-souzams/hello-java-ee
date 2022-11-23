package eric.local.org.controller;

import eric.local.org.enums.TipoEmpresa;
import eric.local.org.model.Empresa;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class GestaoEmpresasController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Empresa empresa;

    public GestaoEmpresasController() {
        this.empresa = new Empresa();
    }

    @PostConstruct
    public void init() {
        System.out.println("Criando bean " + getClass().getName());
    }

    @PreDestroy
    public void ending() {
        System.out.println("Destruindo bean " + getClass().getName());
    }

    public void salvar() {
        System.out.println(empresa);
    }

    public String ajuda() {
        return "AjudaGestaoEmpresas?faces-redirect=true";
    }


    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}
