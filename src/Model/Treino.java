package Model;

public class Treino {

    private String id;
    private Aluno aluno;
    private PersonalTrainer personal;
    private String data;
    private String tipo;
    private String duracaoMinutos;
    private String observacoes;

    public Treino(String id,Aluno aluno, PersonalTrainer personal, String data, String tipo, String duracaoMinutos, String observacoes) {
        this.id = id;
        this.aluno = aluno;
        this.personal = personal;
        this.data = data;
        this.tipo = tipo;
        this.duracaoMinutos = duracaoMinutos;
        this.observacoes = observacoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public PersonalTrainer getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalTrainer personal) {
        this.personal = personal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(String duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
