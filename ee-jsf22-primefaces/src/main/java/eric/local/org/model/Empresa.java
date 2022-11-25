package eric.local.org.model;

import eric.local.org.enums.TipoEmpresa;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;

    @NotEmpty
    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;

    @CNPJ
    @NotNull
    @Column(nullable = false, length = 18)
    private String cnpj;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao")
    private Date dataFundacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id", nullable = false)
    private RamoAtividade ramoAtividade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoEmpresa tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id) && Objects.equals(nomeFantasia, empresa.nomeFantasia) && Objects.equals(razaoSocial, empresa.razaoSocial) && Objects.equals(cnpj, empresa.cnpj) && Objects.equals(dataFundacao, empresa.dataFundacao) && Objects.equals(ramoAtividade, empresa.ramoAtividade) && tipo == empresa.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, razaoSocial, cnpj, dataFundacao, ramoAtividade, tipo);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataFundacao=" + dataFundacao +
                ", ramoAtividade=" + ramoAtividade +
                ", tipo=" + tipo +
                '}';
    }
}
