package Model;

public class Matricula {

    private int id;
    private Aluno aluno;
    private Plano plano;
    private String dataInicio;
    private String dataFinal;
    private boolean ativo;

    public Matricula(int id, Aluno aluno, Plano plano, String dataInicio, String dataFinal, boolean ativo) {
        this.id = id;
        this.aluno = aluno;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.ativo = ativo;
    }

    public int getId(){
            return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Plano getPlano() {
        return plano;

    }

    public void setPlano(Plano plano) {
        this.plano = plano;
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

    public void ativar() {
        this.ativo = true;
    }

    public void desativar(){
        this.ativo = false;
    }

    public boolean isAtivo() {
        return ativo;
    }
}