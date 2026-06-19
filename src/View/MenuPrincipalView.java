package View;

import util.InputHelper;
import util.Logger;

public class MenuPrincipalView {

    private AlunoView alunoView;
    private PersonalView personalView;
    private MatriculaView matriculaView;
    private PagamentoView pagamentoView;
    private TreinoView treinoView;

    public MenuPrincipalView(AlunoView alunoView, PersonalView personalView,
                             MatriculaView matriculaView, PagamentoView pagamentoView,
                             TreinoView treinoView) {
        this.alunoView = alunoView;
        this.personalView = personalView;
        this.matriculaView = matriculaView;
        this.pagamentoView = pagamentoView;
        this.treinoView = treinoView;
        Logger.info("Sistema GymTonica iniciado.");
    }

    public void rodarMenu() {
        int opcao;
        Logger.info("Menu principal carregado.");
        do {
            opcao = exibirMenuPrincipal();
            escolherOpcao(opcao);
        } while (opcao != 6);
        Logger.info("Sistema encerrado pelo usuário.");
    }

    public int exibirMenuPrincipal() {
        System.out.println("\n>>> GYMTONICA <<<");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Personais");
        System.out.println("3. Gerenciar Matrículas");
        System.out.println("4. Realizar Pagamento");
        System.out.println("5. Gerenciar Treino");
        System.out.println("6. Sair");
        System.out.println("------------------------");
        return InputHelper.pegarNumInteiro("Digite o número da ação escolhida: ");
    }

    public void escolherOpcao(int opcao) {
        Logger.debug("Opção selecionada: " + opcao);
        switch (opcao) {
            case 1 -> {
                Logger.info("Acessando menu de Alunos.");
                alunoView.exibirMenuAluno();
            }
            case 2 -> {
                Logger.info("Acessando menu de Personais.");
                personalView.exibirMenuPersonal();
            }
            case 3 -> {
                Logger.info("Acessando menu de Matrículas.");
                matriculaView.exibirMenu();
            }
            case 4 -> {
                Logger.info("Acessando menu de Pagamentos.");
                pagamentoView.rodarMenuPagamento();
            }
            case 5 -> {
                Logger.info("Acessando menu de Treinos.");
                treinoView.exibirMenu();
            }
            case 6 -> {
                Logger.info("Usuário escolheu sair.");
                System.out.println("Encerrando o sistema. Até logo!");
            }
            default -> {
                Logger.aviso("Opção inválida digitada: " + opcao);
                System.out.println("Opção inválida!");
            }
        }
    }
}