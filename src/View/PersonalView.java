package View;

import Controller.PersonalController;
import Model.PersonalTrainer;
import util.InputHelper;

public class PersonalView {

    private PersonalController personalController;

    public PersonalView(PersonalController personalController) {
        this.personalController = personalController;
    }

    public void exibirMenuPersonal() {

        int opcao;

        do {
            System.out.println("\n=== MENU PERSONAL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Alterar");
            System.out.println("5 - Deletar");
            System.out.println("0 - Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscarPorId();
                    break;

                case 4:
                    alterarPersonal();
                    break;

                case 5:
                    deletarPersonal();
                    break;
            }

        } while (opcao != 0);
    }

    public void cadastrar() {

        int id = InputHelper.pegarNumInteiro("ID: ");
        String nome = InputHelper.pegarTexto("Nome: ");
        String cpf = InputHelper.pegarTexto("CPF: ");
        String email = InputHelper.pegarTexto("Email: ");
        String telefone = InputHelper.pegarTexto("Telefone: ");
        String numbCertificacao = InputHelper.pegarTexto("Número da certificação: ");
        String especialidade = InputHelper.pegarTexto("Especialidade: ");

        PersonalTrainer personal = new PersonalTrainer(id, nome, cpf, email, telefone, numbCertificacao, especialidade);

        personalController.cadastrarPersonal(personal);

        System.out.println("Personal cadastrado com sucesso.");
    }

    public void listar() {
        for (PersonalTrainer personal : personalController.listarTodosPersonal()) {
            System.out.println(personal.exibirInfo());
        }
    }

    public void buscarPorId() {
        int id = InputHelper.pegarNumInteiro("Digite o ID: ");

        PersonalTrainer personal = personalController.buscarPorIdPersonal(id);

        if (personal != null) {
            System.out.println(personal.exibirInfo());
        }
        else {
            System.out.println("Personal não encontrado.");
        }
    }

    public void alterarPersonal() {

        int id = InputHelper.pegarNumInteiro("ID do personal: ");

        String nome = InputHelper.pegarTexto("Novo nome: ");
        String cpf = InputHelper.pegarTexto("Novo CPF: ");
        String email = InputHelper.pegarTexto("Novo email: ");
        String telefone = InputHelper.pegarTexto("Novo telefone: ");
        String numbCertificacao = InputHelper.pegarTexto("Nova certificação: ");
        String especialidade = InputHelper.pegarTexto("Nova especialidade: ");

        PersonalTrainer personalAtualizado = new PersonalTrainer(id, nome, cpf, email, telefone, numbCertificacao, especialidade);

        boolean alterou = personalController.alterarPersonal(personalAtualizado);

        if (alterou) {
            System.out.println("Personal alterado com sucesso.");
        }
        else {
            System.out.println("Personal não encontrado.");
        }
    }

    public void deletarPersonal() {
        int id = InputHelper.pegarNumInteiro("ID do personal: ");

        boolean deletou = personalController.deletarPersonal(id);

        if (deletou) {
            System.out.println("Personal removido com sucesso.");
        }
        else {
            System.out.println("Personal não encontrado.");
        }
    }
}