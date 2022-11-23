package eric.local.org.repository;

import eric.local.org.enums.TipoEmpresa;
import eric.local.org.model.Empresa;
import eric.local.org.model.RamoAtividade;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class CamadaPersistencia {

    public static void main(String[] args) {
        try {
            RamoAtividades ramoAtividades = new RamoAtividades();
            Empresas empresas = new Empresas();

            List<Empresa> empresas1 = empresas.pesquisar("");
            List<RamoAtividade> atividades = ramoAtividades.pesquisar("");

            System.out.println(atividades);
            System.out.println(empresas1);

            Empresa empresa = new Empresa();
            empresa.setNomeFantasia("Eric");
            empresa.setCnpj("12.123.123/1234-12");
            empresa.setRazaoSocial("Eric Moves");
            empresa.setTipo(TipoEmpresa.MEI);
            empresa.setDataFundacao(new Date());
            empresa.setRamoAtividade(atividades.get(0));

            empresas.guardar(empresa);

            List<Empresa> empresas2 = empresas.pesquisar("");
            System.out.println(empresas2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
