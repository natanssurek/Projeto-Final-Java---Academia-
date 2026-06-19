import Controller.*;
import View.*;

public class Main {
    public static void main(String[] args) {


        AlunoController alunoController = new AlunoController();
        PersonalController personalController = new PersonalController();
        MatriculaController matriculaController = new MatriculaController();
        ControllerPagamento controllerPagamento = new ControllerPagamento();
        TreinoController treinoController = new TreinoController();


        AlunoView alunoView = new AlunoView(alunoController);
        PersonalView personalView = new PersonalView(personalController);
        MatriculaView matriculaView = new MatriculaView(alunoController, matriculaController);
        PagamentoView pagamentoView = new PagamentoView(alunoController, controllerPagamento);
        TreinoView treinoView = new TreinoView(alunoController, personalController, treinoController);


        MenuPrincipalView menu = new MenuPrincipalView(alunoView, personalView, matriculaView, pagamentoView, treinoView);
        menu.rodarMenu();
    }
}