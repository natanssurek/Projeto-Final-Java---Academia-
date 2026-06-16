package View;

import Controller.AlunoController;
import Controller.ControllerPagamento;
import Model.Aluno;
import util.InputHelper;

public class PagamentoView {

    static ControllerPagamento controllerPagamento = new ControllerPagamento();
    static AlunoController alunoController = new AlunoController();

    public static void rodarMenuPagamento() {
        int opcao = 0;
        do {
            opcao = exibirMenuPagamento();
            escolherOpcaoPagamento(opcao);
        } while (opcao != 6);
    }

    public static void escolherOpcaoPagamento(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarPresencial();
            case 2 -> cadastrarOnline();
            case 3 -> alterar();
            case 4 -> deletar();
            case 5 -> listar();
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Digite uma opção válida!");
        }
    }

    public static int exibirMenuPagamento() {
        System.out.println("---> MENU PAGAMENTO <---");
        System.out.println("1. Cadastrar pagamento presencial");
        System.out.println("2. Cadastrar pagamento online");
        System.out.println("3. Alterar dados do pagamento");
        System.out.println("4. Deletar dados do pagamento");
        System.out.println("5. Listar pagamentos");
        System.out.println("6. Sair");
        System.out.println("------------------------");
        return InputHelper.pegarNumInteiro("Digite o número da ação escolhida:");
    }

    public static void cadastrarPresencial() {
        int idAluno = InputHelper.pegarNumInteiro("Digite o ID do aluno:");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);

        String data = InputHelper.pegarTexto("Digite a data:");
        String formaPagamento = InputHelper.pegarTexto("Digite a forma de pagamento:");

        controllerPagamento.cadastrarPagamentoPresencial(aluno, data, formaPagamento);
        System.out.println("Cadastro de pagamento presencial realizado com sucesso!");
    }

    public static void cadastrarOnline() {
        int idAluno = InputHelper.pegarNumInteiro("Digite o ID do aluno:");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);

        String data = InputHelper.pegarTexto("Digite a data:");
        String plataforma = InputHelper.pegarTexto("Digite a plataforma:");
        double taxaOnline = InputHelper.pegarNumDouble("Digite a taxa online:");

        controllerPagamento.cadastrarPagamentoOnline(aluno, data, false, plataforma, taxaOnline);
        System.out.println("Cadastro de pagamento online realizado com sucesso!");
    }

    public static void alterar() {
        String id = InputHelper.pegarTexto("Digite o ID do pagamento que deseja alterar:");
        controllerPagamento.exibirPorId(id);

        String data = InputHelper.pegarTexto("Digite a nova data:");
        boolean status = InputHelper.pegarNumInteiro("Pagamento confirmado? (1-Sim / 0-Não):") == 1;

        controllerPagamento.alterar(id, data, status);
    }

    public static void deletar() {
        String id = InputHelper.pegarTexto("Digite o ID do pagamento que deseja deletar:");
        controllerPagamento.exibirPorId(id);

        int confirmacao = InputHelper.pegarNumInteiro("Confirmar exclusão? (1-Sim / 0-Não):");
        if (confirmacao == 1) {
            controllerPagamento.deletar(id);
        } else {
            System.out.println("Exclusão cancelada!");
        }
    }

    public static void listar() {
        System.out.println("---> FORMAS DE LISTAMENTO <---");
        System.out.println("1. Listar todos os pagamentos");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Listar por aluno");

        int opcao = InputHelper.pegarNumInteiro("Digite a opção:");

        switch (opcao) {
            case 1 -> controllerPagamento.listarTodos();
            case 2 -> {
                String id = InputHelper.pegarTexto("Digite o ID:");
                controllerPagamento.buscarPorId(id);
            }
            case 3 -> {
                String nomeAluno = InputHelper.pegarTexto("Digite o nome do aluno:");
                controllerPagamento.listarPorAluno(nomeAluno);
            }
            default -> System.out.println("Digite uma opção válida!");
        }
    }
}

