package eric.local.org.repository;

import eric.local.org.model.RamoAtividade;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public RamoAtividades() {}

    public RamoAtividades(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<RamoAtividade> pesquisar(String descricao) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> query = criteriaBuilder.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = query.from(RamoAtividade.class);
        query.select(root);
        query.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));

        TypedQuery<RamoAtividade> query1 = entityManager.createQuery(query);

        return query1.getResultList();
    }
}
