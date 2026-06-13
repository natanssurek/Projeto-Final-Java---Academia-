package Model;

public class PersonalTrainer extends Pessoa {

    private String cref;
    private String especialidade;

    public PersonalTrainer(int id, String nome, String cpf, String email, String telefone, String cref, String especialidade) {
        super(id, nome, cpf, email, telefone);

        this.cref = cref;
        this.especialidade = especialidade;
    }

    public String getCCref() {
        return cref;
    }

    public void setNumbCertificacao(String numbCertificacao) {
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
                "\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nNúmero da Certificação: " + cref +
                "\nEspecialidade: " + especialidade;
    }
}