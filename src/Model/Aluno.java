package Model;

public class Aluno extends Pessoa {

    private static int contadorMatricula = 1;
    private String matricula = "MAT-" + String.format("%05d", contadorMatricula++);
    private static int contador = 1;
    private String idAluno;
    private String objetivo;
    private Plano plano;

    public Aluno(String nome, String cpf, String email, String telefone, String objetivo, Plano plano) {
        super(contador, nome, cpf, email, telefone);
        this.idAluno = "ID ALUNO-" + String.format("%05d", contador++);
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

    public String getObjetivo() {
        return objetivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
                "\nMatricula: " + getMatricula() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nObjetivo: " + objetivo +
                "\nPlano: " + plano.getDescricao() +
                "\nValor do Plano: R$ " + plano.getValor();
    }
}