package eric.local.org.repository;

import eric.local.org.model.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Empresas() {}

    public Empresas(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Empresa porId(Long id) {
        return entityManager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar(String nome) {
        return entityManager.createQuery("select e from Empresa e where e.nomeFantasia like :nomeFantasia", Empresa.class)
                .setParameter("nomeFantasia", nome + "%")
                .getResultList();
    }

    public Empresa guardar(Empresa empresa) {
        return entityManager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        Empresa result = porId(empresa.getId());
        entityManager.remove(result);
    }
}
