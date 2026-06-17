package View;

import Model.Plano;

public class PlanoView {

    public static void listar() {
        System.out.println("====== PLANOS DISPONÍVEIS ======");
        System.out.println("1 - " + Plano.MENSAL.getDescricao() + " | R$ " + Plano.MENSAL.getValor() + " | " + Plano.MENSAL.getDuracaoMeses() + " mês");
        System.out.println("2 - " + Plano.SEMESTRAL.getDescricao() + " | R$ " + Plano.SEMESTRAL.getValor() + " | " + Plano.SEMESTRAL.getDuracaoMeses() + " meses");
        System.out.println("3 - " + Plano.ANUAL.getDescricao() + " | R$ " + Plano.ANUAL.getValor() + " | " + Plano.ANUAL.getDuracaoMeses() + " meses");
        System.out.println("================================");
    }

    public static Plano selecionarPlano(int opcao) {
        return switch (opcao) {
            case 1 -> Plano.MENSAL;
            case 2 -> Plano.SEMESTRAL;
            case 3 -> Plano.ANUAL;
            default -> null;
        };
    }
}
