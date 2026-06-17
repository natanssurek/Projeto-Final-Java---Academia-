package View;

import Controller.AlunoController;
import Controller.ControllerPagamento;
import Model.Aluno;
import Model.Pagamento;
import Model.PagamentoOnline;
import Model.PagamentoPresencial;
import util.InputHelper;

import java.util.List;

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

    public static void cadastrarOnline() {
        int idAluno = InputHelper.pegarNumInteiro("Digite o ID do aluno:");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);

        String data = InputHelper.pegarTexto("Digite a data:");
        String plataforma = InputHelper.pegarTexto("Digite a plataforma:");

        controllerPagamento.cadastrarPagamentoOnline(aluno, data, plataforma);
        System.out.println("Cadastro de pagamento online realizado com sucesso!");
    }

    public static void cadastrarPresencial() {
        int idAluno = InputHelper.pegarNumInteiro("Digite o ID do aluno:");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);

        String data = InputHelper.pegarTexto("Digite a data:");
        String formaPagamento = InputHelper.pegarTexto("Digite a forma de pagamento:");

        controllerPagamento.cadastrarPagamentoPresencial(aluno, data, formaPagamento);
        System.out.println("Cadastro de pagamento presencial realizado com sucesso!");
    }

    public static void alterar() {
        String id = InputHelper.pegarTexto("Digite o ID do pagamento:");
        Pagamento p = controllerPagamento.buscarPorId(id);
        if (p == null) { System.out.println("Pagamento inexistente!"); return; }
        System.out.println(p.exibirInfo());

        String data = InputHelper.pegarTexto("Digite a nova data:");
        boolean status = InputHelper.pegarNumInteiro("Pagamento confirmado? (1-Sim / 0-Não):") == 1;

        if (controllerPagamento.alterar(id, data, status)) {
            System.out.println("Pagamento alterado com sucesso!");
        } else {
            System.out.println("Pagamento inexistente!");
        }
    }

    public static void deletar() {
        String id = InputHelper.pegarTexto("Digite o ID do pagamento que deseja deletar:");
        Pagamento p = controllerPagamento.buscarPorId(id);
        if (p == null) { System.out.println("Pagamento inexistente!"); return; }
        System.out.println(p.exibirInfo());

        int confirmacao = InputHelper.pegarNumInteiro("Confirmar exclusão? (1-Sim / 0-Não):");
        if (confirmacao == 1) {
            if (controllerPagamento.deletar(id)) {
                System.out.println("Pagamento deletado com sucesso!");
            } else {
                System.out.println("Pagamento inexistente!");
            }
        } else {
            System.out.println("Exclusão cancelada!");
        }
    }

    public static void listarTodos() {
        System.out.println("---> PAGAMENTOS ONLINE <---");
        for (PagamentoOnline p : controllerPagamento.getListaPagamentoOnline()) {
            System.out.println(p.exibirInfo());
            System.out.println("----------------------------");
        }

        System.out.println("---> PAGAMENTOS PRESENCIAIS <---");
        for (PagamentoPresencial p : controllerPagamento.getListaPagamentoPresencial()) {
            System.out.println(p.exibirInfo());
            System.out.println("---------------------------------");
        }
    }

    public static void listar() {
        System.out.println("---> FORMAS DE LISTAMENTO <---");
        System.out.println("1. Listar todos os pagamentos");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Listar por aluno");

        int opcao = InputHelper.pegarNumInteiro("Digite a opção:");

        switch (opcao) {
            case 1 -> listarTodos();
            case 2 -> {
                String id = InputHelper.pegarTexto("Digite o ID:");
                Pagamento p = controllerPagamento.buscarPorId(id);
                if (p != null) System.out.println(p.exibirInfo());
                else System.out.println("Pagamento inexistente!");
            }
            case 3 -> {
                String nomeAluno = InputHelper.pegarTexto("Digite o nome do aluno:");
                List<Pagamento> pagamentos = controllerPagamento.listarPorAluno(nomeAluno);
                if (pagamentos.isEmpty()) System.out.println("Nenhum pagamento encontrado!");
                else pagamentos.forEach(p -> System.out.println(p.exibirInfo()));
            }
            default -> System.out.println("Digite uma opção válida!");
        }
    }
}

