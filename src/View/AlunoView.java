package View;

import Controller.AlunoController;
import Model.Aluno;
import util.InputHelper;

public class AlunoView {

    private AlunoController alunoController;

    public AlunoView(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    public void exibirMenuAluno() {

        int opcao;

        do {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Alterar");
            System.out.println("5 - Deletar");
            System.out.println("0 - Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    listarAluno();
                    break;

                case 3:
                    buscarPorIdAluno();
                    break;

                case 4:
                    alterarAluno();
                    break;

                case 5:
                    deletarAluno();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public void cadastrarAluno() {

        int id = InputHelper.pegarNumInteiro("ID: ");
        String nome = InputHelper.pegarTexto("Nome: ");
        String cpf = InputHelper.pegarTexto("CPF: ");
        String email = InputHelper.pegarTexto("Email: ");
        String telefone = InputHelper.pegarTexto("Telefone: ");
        String matricula = InputHelper.pegarTexto("Matrícula: ");
        String objetivo = InputHelper.pegarTexto("Objetivo: ");

        Aluno aluno = new Aluno(id, nome, cpf, email, telefone, matricula, objetivo);

        alunoController.cadastrarAluno(aluno);

        System.out.println("Aluno cadastrado com sucesso.");
    }

    public void listarAluno() {
        for (Aluno aluno : alunoController.listarTodosAluno()) {
            System.out.println(aluno.exibirInfo());
        }
    }

    public void buscarPorIdAluno() {

        int id = InputHelper.pegarNumInteiro("Digite o ID: ");

        Aluno aluno = alunoController.buscarPorIdAluno(id);

        if (aluno != null) {
            System.out.println(aluno.exibirInfo());
        }
        else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void alterarAluno() {

        int id = InputHelper.pegarNumInteiro("ID do aluno: ");

        String nome = InputHelper.pegarTexto("Novo nome: ");
        String cpf = InputHelper.pegarTexto("Novo CPF: ");
        String email = InputHelper.pegarTexto("Novo email: ");
        String telefone = InputHelper.pegarTexto("Novo telefone: ");
        String matricula = InputHelper.pegarTexto("Nova matrícula: ");
        String objetivo = InputHelper.pegarTexto("Novo objetivo: ");

        Aluno alunoAtualizado = new Aluno(id, nome, cpf, email, telefone, matricula, objetivo);

        boolean alterou =
                alunoController.alterarAluno(alunoAtualizado);

        if (alterou) {
            System.out.println("Aluno alterado com sucesso.");
        }
        else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void deletarAluno() {

        int id = InputHelper.pegarNumInteiro("ID do aluno: ");

        boolean deletou = alunoController.deletarAluno(id);

        if (deletou) {
            System.out.println("Aluno removido com sucesso.");
        }
        else {
            System.out.println("Aluno não encontrado.");
        }
    }
}