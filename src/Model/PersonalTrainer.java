package Model;

public class PersonalTrainer extends Pessoa {

    private static int contador = 1;
    private String idPersonal;

    private String cref;
    private String especialidade;

    public PersonalTrainer(String nome, String cpf, String email, String telefone, String cref, String especialidade) {
        super(contador, nome, cpf, email, telefone);
        this.idPersonal = "ID PERSONAL-" + contador++;
        this.cref = cref;
        this.especialidade = especialidade;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public String getCref() {
        return cref;
    }
    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String exibirInfo() {
        return "\n=== PERSONAL TRAINER ===" +
                "\nID: " + idPersonal +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nNúmero da Certificação: " + cref +
                "\nEspecialidade: " + especialidade;
    }
}