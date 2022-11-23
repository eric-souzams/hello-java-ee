package eric.local.org.service;

import eric.local.org.model.Empresa;
import eric.local.org.repository.Empresas;
import eric.local.org.util.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Transactional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transactional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }

    public List<Empresa> listar() {
        return empresas.pesquisar("");
    }

}
