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
            System.out.println("4 - Buscar por CPF");
            System.out.println("5 - Alterar");
            System.out.println("6 - Deletar");
            System.out.println("0 - Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrarAluno(); break;
                case 2: listarAluno(); break;
                case 3: buscarPorIdAluno(); break;
                case 4: buscarPorCPFAluno(); break;
                case 5: alterarAluno(); break;
                case 6: deletarAluno(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
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
        String id = InputHelper.pegarTexto("Digite o ID (ex: ID ALUNO-1): ");
        Aluno aluno = alunoController.buscarPorIdAluno(id);

        if (aluno != null) {
            System.out.println(aluno.exibirInfo());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void buscarPorCPFAluno() {
        String cpf = InputHelper.pegarTexto("Digite o CPF: ");
        Aluno aluno = alunoController.buscarPorCPFAluno(cpf);

        if (aluno != null) {
            System.out.println(aluno.exibirInfo());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void alterarAluno() {
        System.out.println("COMO DESEJA LOCALIZAR O ALUNO?");
        System.out.println("1 - ID");
        System.out.println("2 - CPF");

        int opcao = InputHelper.pegarNumInteiro("Escolha: ");
        Aluno alunoEncontrado = null;

        switch (opcao) {
            case 1:
                String id = InputHelper.pegarTexto("Digite o ID (ex: ID ALUNO-1): ");
                alunoEncontrado = alunoController.buscarPorIdAluno(id);
                break;
            case 2:
                String cpf = InputHelper.pegarTexto("Digite o CPF: ");
                alunoEncontrado = alunoController.buscarPorCPFAluno(cpf);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (alunoEncontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        String novoNome = InputHelper.pegarTexto("Novo nome: ");
        String novoEmail = InputHelper.pegarTexto("Novo email: ");
        String novoTelefone = InputHelper.pegarTexto("Novo telefone: ");
        String novaMatricula = InputHelper.pegarTexto("Nova matrícula: ");
        String novoObjetivo = InputHelper.pegarTexto("Novo objetivo: ");

        planoController.exibirPlanos();
        int opcaoPlano = InputHelper.pegarNumInteiro("Escolha o novo Plano (1-3): ");
        Plano novoPlano = planoController.selecionarPlano(opcaoPlano);

        if (novoPlano == null) return;

        Aluno alunoAtualizado = new Aluno(novoNome, alunoEncontrado.getCpf(), novoEmail, novoTelefone, novaMatricula, novoObjetivo, novoPlano);

        switch (opcao) {
            case 1:
                alunoController.alterarAlunoPorId(alunoEncontrado.getIdAluno(), alunoAtualizado);
                break;
            case 2:
                alunoController.alterarAlunoPorCpf(alunoEncontrado.getCpf(), alunoAtualizado);
                break;
        }

        System.out.println("Aluno alterado com sucesso.");
    }

    public void deletarAluno() {
        System.out.println("COMO DESEJA LOCALIZAR O ALUNO?");
        System.out.println("1 - ID");
        System.out.println("2 - CPF");

        int opcao = InputHelper.pegarNumInteiro("Escolha: ");
        Aluno alunoEncontrado = null;

        switch (opcao) {
            case 1:
                String id = InputHelper.pegarTexto("Digite o ID (ex: ID ALUNO-1): ");
                alunoEncontrado = alunoController.buscarPorIdAluno(id);
                break;
            case 2:
                String cpf = InputHelper.pegarTexto("Digite o CPF: ");
                alunoEncontrado = alunoController.buscarPorCPFAluno(cpf);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (alunoEncontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        alunoController.deletarAluno(alunoEncontrado.getIdAluno());
        System.out.println("Aluno removido com sucesso.");
    }
}