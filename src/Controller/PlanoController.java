package Controller;

import Model.Plano;
import View.PlanoView;

public class PlanoController {

    public void exibirPlanos() {
        PlanoView.listar();
    }

    public Plano selecionarPlano(int opcao) {
        Plano plano = PlanoView.selecionarPlano(opcao);

        if (plano == null) {
            System.out.println("Opção inválida. Plano não encontrado.");
        }

        return plano;
    }
}