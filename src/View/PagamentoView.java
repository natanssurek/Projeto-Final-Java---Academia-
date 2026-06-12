package View;

import Controller.ControllerPagamento;
import Model.InputHelper;

public class PagamentoView {

    static ControllerPagamento controllerPagamento = new ControllerPagamento();

    public static void rodarMenuPagamento() {
       int opcao = 0;
       do{
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
        String id = InputHelper.pegarTexto("Digite o ID:");
        double valor = InputHelper.pegarNumDouble("Digite o valor:");
        String data = InputHelper.pegarTexto("Digite a data:");
        String formaPagamento = InputHelper.pegarTexto("Digite a forma de pagamento:");

        controllerPagamento.cadastrarPagamentoPresencial(id, valor, data, false, formaPagamento);
        System.out.println("Cadastro de pagamento realizado com sucesso!");


    }

    public static void cadastrarOnline() {
        String id = InputHelper.pegarTexto("Digite o ID:");
        double valor = InputHelper.pegarNumDouble("Digite o valor:");
        String data = InputHelper.pegarTexto("Digite a data:");
        String plataforma = InputHelper.pegarTexto("Digite a plataforma:");
        double taxaOnline = InputHelper.pegarNumDouble("Digite a taxa online:");

        controllerPagamento.cadastrarPagamentoOnline(id, valor, data, false, plataforma, taxaOnline);
        System.out.println("Cadastro de pagamento realizado com sucesso!");
    }

    public static void alterar() {

        String id = InputHelper.pegarTexto("Digite o ID:");
        double valor = InputHelper.pegarNumDouble("Digite o valor:");
        String data = InputHelper.pegarTexto("Digite a data:");

        controllerPagamento.alterar(id, valor, data);
    }

    public static void deletar() {
        String id = InputHelper.pegarTexto("Digite o ID do pagamento que deseja deletar:");
        controllerPagamento.deletar(id);
    }

    public static void listar() {

        System.out.println("---> FORMAS DE LISTAMENTO DE PAGAMENTO <---");
        System.out.println("1. Listar todos os pagamentos");
        System.out.println("2. Listar pagamentos por ID");
        /*System.out.println("3. Listar pagamentos por alunos");*/

        int opcao = InputHelper.pegarNumInteiro("Digite a opção que deseja:");

        switch(opcao) {
            case 1 -> controllerPagamento.listarTodos();
            case 2 -> {
                String id = InputHelper.pegarTexto("Digite o ID:");
                controllerPagamento.buscarPorId(id);
            }

            /*case 3 -> controllerPagamento.listarPorAluno();*/

            default -> System.out.println("Digite uma opção válida!");
        }



    }

}

