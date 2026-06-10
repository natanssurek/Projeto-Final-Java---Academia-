package Model;

public class Matricula {

    private String id;
    //private Aluno aluno;
    //private Plano plano;
    private String dataInicio;
    private String dataFinal;
    private boolean ativo;

    public Matricula(String id, String dataInicio, String dataFinal){
        this.id=id;
        this.dataInicio=dataInicio;
        this.dataFinal=dataFinal;
        this.ativo=true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    public void ativar(){
        this.ativo=true;
    }
    public void desativar(){
        this.ativo=false;
    }
    public boolean isAtivo(){
        return ativo;
    }
}
