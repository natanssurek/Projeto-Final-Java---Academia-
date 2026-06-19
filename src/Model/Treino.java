package Model;

public class Treino {

    private static int contador = 1;
    private String id;

    private Aluno aluno;
    private PersonalTrainer personal;
    private String data;
    private String tipo;
    private int duracaoMinutos;
    private String observacoes;

    public Treino(Aluno aluno, PersonalTrainer personal, String data, String tipo, int duracaoMinutos, String observacoes) {
        this.id = "TREINO-" + contador++;
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

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personal;
    }
    public void setPersonalTrainer(PersonalTrainer personal) {
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

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}