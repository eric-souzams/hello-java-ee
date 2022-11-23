package eric.local.org.enums;

public enum TipoEmpresa {

    MEI("Microempreendedor Individual"),
    EIRELI("Empresa Inidividual de Responsabilidade Limitada"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anônima");

    private String descricao;

    TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
