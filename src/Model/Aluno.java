package Model;

public class Aluno extends Pessoa {

    private String matricula;
    private String objetivo;
    private Plano plano;

    public Aluno(int id, String nome, String cpf, String email, String telefone, String matricula, String objetivo, Plano plano) {
        super(id, nome, cpf, email, telefone);
        this.matricula = matricula;
        this.objetivo = objetivo;
        this.plano = plano;
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
                "\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nMatrícula: " + matricula +
                "\nObjetivo: " + objetivo;
    }

}