package View;

import Controller.AlunoController;
import Controller.MatriculaController;
import Controller.PlanoController;
import Model.Aluno;
import Model.Matricula;
import Model.Plano;
import util.InputHelper;

public class MatriculaView {

    private AlunoController alunoController;
    private MatriculaController matriculaController;
    private PlanoController planoController;

    public MatriculaView(AlunoController alunoController, MatriculaController matriculaController) {
        this.alunoController = alunoController;
        this.matriculaController = matriculaController;
        this.planoController = new PlanoController(); // <- não precisa injetar, não tem lista
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("===== MENU MATRÍCULA =====");
            System.out.println("1. Matricular Aluno");
            System.out.println("2. Alterar Matrícula");
            System.out.println("3. Remover Matrícula");
            System.out.println("4. Listar Alunos Matriculados");
            System.out.println("6. Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: alterar(); break;
                case 3: deletar(); break;
                case 4: listar(); break;
                case 6: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
        } while (opcao != 6);
    }

    private void cadastrar() {
        System.out.println("\n--- NOVA MATRÍCULA ---");

        String idAluno = InputHelper.pegarTexto("ID do Aluno (ex: ALUNO-1): ");
        Aluno alunoObj = alunoController.buscarPorIdAluno(idAluno);

        if (alunoObj == null) {
            System.out.println("Erro: Aluno não cadastrado no sistema!");
            return;
        }

        planoController.exibirPlanos();
        int opcaoPlano = InputHelper.pegarNumInteiro("Escolha o Plano (1-3): ");
        Plano planoEscolhido = planoController.selecionarPlano(opcaoPlano);

        if (planoEscolhido == null) return;

        String dataInicio = InputHelper.pegarTexto("Data de Início (dd/mm/aaaa): ");
        String dataFinal = InputHelper.pegarTexto("Data de Término (dd/mm/aaaa): ");

        Matricula nova = new Matricula(alunoObj, planoEscolhido, dataInicio, dataFinal, true);
        matriculaController.matriculaAluno(nova);

        System.out.println("\nAluno " + alunoObj.getNome() + " matriculado com sucesso!");
        System.out.println("Plano: " + planoEscolhido.getDescricao() + " | Valor: R$ " + planoEscolhido.getValor());
        System.out.println("Mensalidade: R$ " + planoEscolhido.calcularMensalidade() + "/mês");
    }

    private void alterar() {
        System.out.println("\n--- ALTERAR MATRÍCULA ---");
        String id = InputHelper.pegarTexto("ID da Matrícula (ex: MATRICULA-1): ");
        Matricula mat = matriculaController.buscaPorId(id);

        if (mat == null) {
            System.out.println("Matrícula não encontrada.");
            return;
        }

        System.out.println("Alterando matrícula de: " + mat.getAluno().getNome());
        System.out.println("Plano Atual: " + mat.getPlano().getDescricao());

        planoController.exibirPlanos();
        int opcaoPlano = InputHelper.pegarNumInteiro("Escolha o Novo Plano (1-3): ");
        Plano novoPlano = planoController.selecionarPlano(opcaoPlano);

        if (novoPlano == null) return;

        String novaDataInicio = InputHelper.pegarTexto("Nova Data de Início: ");
        String novaDataFinal = InputHelper.pegarTexto("Nova Data de Término: ");

        matriculaController.alterarMatricula(id, novoPlano, novaDataInicio, novaDataFinal);
        System.out.println("Matrícula atualizada com sucesso!");
    }

    private void deletar() {
        String id = InputHelper.pegarTexto("ID da Matrícula (ex: MATRICULA-1): ");
        if (matriculaController.removerMatricula(id)) {
            System.out.println("Matrícula removida!");
        } else {
            System.out.println("Não encontrada.");
        }
    }

    private void listar() {
        System.out.println("\n--- ALUNOS MATRICULADOS ---");
        if (matriculaController.listarMatriculados().isEmpty()) {
            System.out.println("Nenhuma matrícula ativa.");
            return;
        }
        for (Matricula m : matriculaController.listarMatriculados()) {
            System.out.println("ID Matrícula: " + m.getId() +
                    " | Aluno: " + m.getAluno().getNome() +
                    " | Plano: " + m.getPlano().getDescricao() +
                    " | Valor: R$ " + m.getPlano().getValor() +
                    " | Ativo: " + m.isAtivo());
        }
    }
}