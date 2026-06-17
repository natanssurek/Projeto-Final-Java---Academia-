package View;

import util.InputHelper;

public class MenuPrincipalView {
    private AlunoView menuAluno;
    private PersonalView menuPersonal;

    public MenuPrincipalView(AlunoView menuAluno, PersonalView menuPersonal) {
        this.menuAluno = menuAluno;
        this.menuPersonal = menuPersonal;
    }

    public void exibirMenuPrincipal() {

        int opcao;

        do {
            System.out.println("\n>>> GYMTONICA <<<");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Personais");
            //System.out.println("3 - ");
            //System.out.println("4 - ...");
            //System.out.println("5 - ...");
            System.out.println("0 - Sair");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    menuAluno.exibirMenuAluno();
                    break;

                case 2:
                    menuPersonal.exibirMenuPersonal();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}