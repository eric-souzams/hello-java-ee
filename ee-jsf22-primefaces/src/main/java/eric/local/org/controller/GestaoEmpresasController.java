package eric.local.org.controller;

import eric.local.org.converters.RamoAtividadeConverter;
import eric.local.org.enums.TipoEmpresa;
import eric.local.org.model.Empresa;
import eric.local.org.model.RamoAtividade;
import eric.local.org.repository.Empresas;
import eric.local.org.repository.RamoAtividades;
import eric.local.org.service.CadastroEmpresaService;
import eric.local.org.util.FacesMessages;
import org.primefaces.context.RequestContext;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class GestaoEmpresasController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private FacesMessages messages;
    @Inject
    private Empresas empresaRepository;
    @Inject
    private RamoAtividades ramoAtividadeRepository;
    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    private Converter ramoAtividadeConverter;
    private String termoPesquisa;
    private Empresa empresa;
    private List<Empresa> empresas;


    public void prepararNovaEmpresa() {
        this.empresa = new Empresa();
    }

    public void prepararEdicaoEmpresa() {
        ramoAtividadeConverter = new RamoAtividadeConverter(Collections.singletonList(empresa.getRamoAtividade()));
    }

    public void excluirEmpresa() {
        cadastroEmpresaService.excluir(empresa);

        empresas = null;

        atualizarRegistros();

        messages.info("Empresa excluída com sucesso!");
    }

    public void salvar() {
        cadastroEmpresaService.salvar(this.empresa);

        atualizarRegistros();

        messages.info("Empresa salva com sucesso!");

        RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:empresasDataTable",
                "frm:messagesHeader"
        ));
    }

    public void buscarEmpresas() {
        this.empresas = this.empresaRepository.todas();
    }

    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> resultados = ramoAtividadeRepository.pesquisar(termo);

        ramoAtividadeConverter = new RamoAtividadeConverter(resultados);

        return resultados;
    }

    public void pesquisar() {
        this.empresas = this.empresaRepository.pesquisar(this.termoPesquisa);

        if (this.empresas.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
    }

    private boolean jaHouvePesquisa() {
        return this.termoPesquisa != null && !"".equals(this.termoPesquisa);
    }

    private void atualizarRegistros() {
        if (jaHouvePesquisa()) {
            pesquisar();
        } else {
            buscarEmpresas();
        }
    }

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }

    public boolean isEmpresaSelecionada() {
        return empresa != null && empresa.getId() != null;
    }
}
