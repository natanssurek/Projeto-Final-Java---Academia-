package View;

import Controller.PersonalController;
import Model.PersonalTrainer;
import util.InputHelper;

public class PersonalView {

    private PersonalController gerenciarPersonal;

    public PersonalView(PersonalController gerenciarPersonal) {
        this.gerenciarPersonal = gerenciarPersonal;
    }

    public void exibirMenuPersonal() {
        int opcao;
        do {
            System.out.println("\n=== MENU PERSONAL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Buscar por CPF");
            System.out.println("5 - Buscar por Cref");
            System.out.println("6 - Alterar");
            System.out.println("7 - Deletar");
            System.out.println("8 - Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscarPorId(); break;
                case 4: buscarPorCPF(); break;
                case 5: buscarPorCref(); break;
                case 6: alterarPersonal(); break;
                case 7: deletarPersonal(); break;
                case 8:
                    System.out.println("Voltando...");break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 8);
    }

    public void cadastrar() {
        String nome = InputHelper.pegarTexto("Nome: ");
        String cpf = InputHelper.pegarTexto("CPF: ");
        String email = InputHelper.pegarTexto("Email: ");
        String telefone = InputHelper.pegarTexto("Telefone: ");
        String cref = InputHelper.pegarTexto("CREF: ");
        String especialidade = InputHelper.pegarTexto("Especialidade: ");

        PersonalTrainer personal = new PersonalTrainer(nome, cpf, email, telefone, cref, especialidade);
        gerenciarPersonal.cadastrarPersonal(personal);
        System.out.println("Personal cadastrado com sucesso.");
    }

    public void listar() {
        for (PersonalTrainer personal : gerenciarPersonal.listarTodosPersonal()) {
            System.out.println(personal.exibirInfo());
        }
    }

    public void buscarPorId() {
        String id = InputHelper.pegarTexto("Digite o ID (ex: ID PERSONAL-00001): ");
        PersonalTrainer personal = gerenciarPersonal.buscarPorIdPersonal(id);

        if (personal != null) {
            System.out.println(personal.exibirInfo());
        } else {
            System.out.println("Personal não encontrado.");
        }
    }

    public void buscarPorCPF() {
        String cpf = InputHelper.pegarTexto("Digite o CPF: ");
        PersonalTrainer personal = gerenciarPersonal.buscarPorCPFPersonal(cpf);

        if (personal != null) {
            System.out.println(personal.exibirInfo());
        } else {
            System.out.println("Personal não encontrado.");
        }
    }

    public void buscarPorCref() {
        String cref = InputHelper.pegarTexto("Digite o CREF: ");
        PersonalTrainer personal = gerenciarPersonal.buscarPorCrefPersonal(cref);

        if (personal != null) {
            System.out.println(personal.exibirInfo());
        } else {
            System.out.println("Personal não encontrado.");
        }
    }

    public void alterarPersonal() {
        System.out.println("COMO DESEJA LOCALIZAR O PERSONAL?");
        System.out.println("1 - ID");
        System.out.println("2 - CPF");

        int opcao = InputHelper.pegarNumInteiro("Escolha: ");
        PersonalTrainer personalEncontrado = null;

        switch (opcao) {
            case 1:
                String id = InputHelper.pegarTexto("Digite o ID (ex: ID PERSONAL-00001): ");
                personalEncontrado = gerenciarPersonal.buscarPorIdPersonal(id);
                break;
            case 2:
                String cpf = InputHelper.pegarTexto("Digite o CPF: ");
                personalEncontrado = gerenciarPersonal.buscarPorCPFPersonal(cpf);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (personalEncontrado == null) {
            System.out.println("Personal não encontrado.");
            return;
        }

        String novoNome = InputHelper.pegarTexto("Novo nome: ");
        String novoEmail = InputHelper.pegarTexto("Novo email: ");
        String novoTelefone = InputHelper.pegarTexto("Novo telefone: ");
        String novoCref = InputHelper.pegarTexto("Novo CREF: ");
        String novaEspecialidade = InputHelper.pegarTexto("Nova especialidade: ");

        PersonalTrainer personalAtualizado = new PersonalTrainer(novoNome, personalEncontrado.getCpf(), novoEmail, novoTelefone, novoCref, novaEspecialidade);

        switch (opcao) {
            case 1:
                gerenciarPersonal.alterarPersonal(personalEncontrado.getIdPersonal(), personalAtualizado);
                break;
            case 2:
                gerenciarPersonal.alterarPersonal(personalEncontrado.getCpf(), personalAtualizado, true);
                break;
        }

        System.out.println("Personal alterado com sucesso.");
    }

    public void deletarPersonal() {
        System.out.println("COMO DESEJA LOCALIZAR O PERSONAL?");
        System.out.println("1 - ID");
        System.out.println("2 - CPF");

        int opcao = InputHelper.pegarNumInteiro("Escolha: ");
        PersonalTrainer personalEncontrado = null;

        switch (opcao) {
            case 1:
                String id = InputHelper.pegarTexto("Digite o ID (ex: ID PERSONAL-00001): ");
                personalEncontrado = gerenciarPersonal.buscarPorIdPersonal(id);
                break;
            case 2:
                String cpf = InputHelper.pegarTexto("Digite o CPF: ");
                personalEncontrado = gerenciarPersonal.buscarPorCPFPersonal(cpf);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (personalEncontrado == null) {
            System.out.println("Personal não encontrado.");
            return;
        }

        gerenciarPersonal.deletarPersonal(personalEncontrado);
        System.out.println("Personal removido com sucesso.");
    }
}