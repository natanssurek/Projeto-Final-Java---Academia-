package Model;

public class Aluno extends Pessoa {

    private static int contador = 1;
    private String idAluno;

    private String matricula;
    private String objetivo;
    private Plano plano;

    public Aluno(String nome, String cpf, String email, String telefone, String matricula, String objetivo, Plano plano) {
        super(contador, nome, cpf, email, telefone);
        this.idAluno = "ID ALUNO-" + contador++;
        this.matricula = matricula;
        this.objetivo = objetivo;
        this.plano = plano;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String exibirInfo() {
        return "\n=== ALUNO ===" +
                "\nID: " + idAluno +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nMatrícula: " + matricula +
                "\nObjetivo: " + objetivo +
                "\nPlano: " + plano.getDescricao() +
                "\nValor do Plano: R$ " + plano.getValor();
    }
}