package View;

import Controller.AlunoController;
import Controller.PlanoController;
import Model.Aluno;
import Model.Plano;
import util.InputHelper;

public class AlunoView {

    private AlunoController alunoController;
    private PlanoController planoController;

    public AlunoView(AlunoController alunoController) {
        this.alunoController = alunoController;
        this.planoController = new PlanoController();
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
        String nome = InputHelper.pegarTexto("Nome: ");
        String cpf = InputHelper.pegarTexto("CPF: ");
        String email = InputHelper.pegarTexto("Email: ");
        String telefone = InputHelper.pegarTexto("Telefone: ");
        String matricula = InputHelper.pegarTexto("Matrícula: ");
        String objetivo = InputHelper.pegarTexto("Objetivo: ");

        planoController.exibirPlanos();
        int opcao = InputHelper.pegarNumInteiro("Escolha o Plano (1-3): ");
        Plano plano = planoController.selecionarPlano(opcao);

        if (plano == null) return;

        Aluno aluno = new Aluno(nome, cpf, email, telefone, matricula, objetivo, plano);
        alunoController.cadastrarAluno(aluno);

        System.out.println("Aluno cadastrado com sucesso.");
    }

    public void listarAluno() {
        for (Aluno aluno : alunoController.listarTodosAluno()) {
            System.out.println(aluno.exibirInfo());
        }
    }

    public void buscarPorIdAluno() {
        int id = InputHelper.pegarNumInteiro("Digite o ID numérico do aluno: ");

        Aluno aluno = alunoController.buscarPorIdAluno(id);

        if (aluno != null) {
            System.out.println(aluno.exibirInfo());
        }
        else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void alterarAluno() {
        int id = InputHelper.pegarNumInteiro("ID numérico do aluno que deseja alterar: ");

        Aluno alunoExistente = alunoController.buscarPorIdAluno(id);
        if (alunoExistente == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        String nome = InputHelper.pegarTexto("Novo nome: ");
        String cpf = InputHelper.pegarTexto("Novo CPF: ");
        String email = InputHelper.pegarTexto("Novo email: ");
        String telefone = InputHelper.pegarTexto("Novo telefone: ");
        String matricula = InputHelper.pegarTexto("Nova matrícula: ");
        String objetivo = InputHelper.pegarTexto("Novo objetivo: ");

        planoController.exibirPlanos();
        int opcao = InputHelper.pegarNumInteiro("Escolha o novo Plano (1-3): ");
        Plano plano = planoController.selecionarPlano(opcao);

        if (plano == null) return;

        Aluno alunoAtualizado = new Aluno(nome, cpf, email, telefone, matricula, objetivo, plano);

        boolean alterou = alunoController.alterarAluno(alunoAtualizado);

        if (alterou) {
            System.out.println("Aluno alterado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar o aluno.");
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