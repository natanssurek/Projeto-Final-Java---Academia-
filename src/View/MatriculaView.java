package View;

import Controller.AlunoController;
import Controller.MatriculaController;
import Model.Aluno;
import Model.Matricula;
import Model.Plano;
import util.InputHelper;

public class MatriculaView {

    private static MatriculaController matriculaController = new MatriculaController();
    private static AlunoController     alunoController     = new AlunoController();

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("===== MENU MATRÍCULA =====");
            System.out.println("1. Matricular Aluno");
            System.out.println("2. Alterar Matrícula");
            System.out.println("3. Remover Matrícula");
            System.out.println("4. Listar Alunos Matriculados");
            System.out.println("0. Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:  cadastrar(); break;
                case 2:  alterar();   break;
                case 3:  deletar();   break;
                case 4:  listar();    break;
                case 0:  System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.println("\n--- NOVA MATRÍCULA ---");

        int idMatricula = InputHelper.pegarNumInteiro("ID da Matrícula: ");
        if (idMatricula == -1) return;

        int idAluno = InputHelper.pegarNumInteiro("ID do Aluno Existente: ");
        Aluno alunoObj = alunoController.buscarPorIdAluno(idAluno);

        if (alunoObj == null) {
            System.out.println("Erro: Aluno não cadastrado no sistema!");
            return;
        }

        Plano planoEscolhido = escolherPlano();
        if (planoEscolhido == null) {
            System.out.println("Opção de plano inválida!");
            return;
        }

        // Desconto de estudante disponível apenas no plano anual
        if (planoEscolhido == Plano.ANUAL) {
            System.out.println("Aplicar desconto de estudante (10%)? (1-Sim / 2-Não)");
            int descOpcao = InputHelper.pegarNumInteiro("Opção: ");
            if (descOpcao == 1) {
                double valorComDesconto = planoEscolhido.calcularDesconto(10);
                System.out.printf("Desconto aplicado! Valor com desconto: R$ %.2f%n", valorComDesconto);
            }
        }

        String dataInicio = InputHelper.pegarTexto("Data de Início (dd/mm/aaaa): ");
        String dataFinal  = InputHelper.pegarTexto("Data de Término (dd/mm/aaaa): ");

        Matricula nova = new Matricula(idMatricula, alunoObj, planoEscolhido, dataInicio, dataFinal, true);
        matriculaController.matriculaAluno(nova);

        System.out.println("\nAluno " + alunoObj.getNome() + " matriculado com sucesso!");
        System.out.printf("Plano: %s | Valor Total: R$ %.2f%n",
                planoEscolhido.getDescricao(), planoEscolhido.getValor());
        System.out.printf("Mensalidade: R$ %.2f/mês%n",
                planoEscolhido.calcularMensalidade());
    }

    private static void alterar() {
        System.out.println("\n--- ALTERAR MATRÍCULA ---");

        int id = InputHelper.pegarNumInteiro("Digite o ID da Matrícula: ");
        Matricula mat = matriculaController.buscaPorId(id);

        if (mat == null) {
            System.out.println("Matrícula não encontrada.");
            return;
        }

        System.out.println("Aluno: "       + mat.getAluno().getNome());
        System.out.println("Plano Atual: " + mat.getPlano().getDescricao());

        Plano novoPlano = escolherPlano();
        if (novoPlano == null) {
            System.out.println("Opção de plano inválida!");
            return;
        }

        String novaDataInicio = InputHelper.pegarTexto("Nova Data de Início (dd/mm/aaaa): ");
        String novaDataFinal  = InputHelper.pegarTexto("Nova Data de Término (dd/mm/aaaa): ");

        matriculaController.alterarMatricula(id, novoPlano, novaDataInicio, novaDataFinal);
        System.out.println("Matrícula atualizada com sucesso!");
    }

    private static void deletar() {
        int id = InputHelper.pegarNumInteiro("ID da Matrícula para remover: ");
        if (matriculaController.removerMatricula(id)) {
            System.out.println("Matrícula removida!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    private static void listar() {
        System.out.println("\n--- ALUNOS MATRICULADOS ---");
        if (matriculaController.listarMatriculados().isEmpty()) {
            System.out.println("Nenhuma matrícula ativa.");
            return;
        }
        for (Matricula m : matriculaController.listarMatriculados()) {
            System.out.printf("ID: %d | Aluno: %s | Plano: %s | Valor: R$ %.2f | Mensalidade: R$ %.2f/mês | Ativo: %b%n",
                    m.getId(),
                    m.getAluno().getNome(),
                    m.getPlano().getDescricao(), // era getId() — não existe em Plano
                    m.getPlano().getValor(),
                    m.getPlano().calcularMensalidade(),
                    m.isAtivo());
        }
    }

    private static Plano escolherPlano() {
        System.out.println("Escolha o Plano:");
        System.out.printf("1. %s  — R$ %.2f/mês%n",
                Plano.MENSAL.getDescricao(), Plano.MENSAL.getValor());
        System.out.printf("2. %s  — R$ %.2f total (R$ %.2f/mês)%n",
                Plano.SEMESTRAL.getDescricao(), Plano.SEMESTRAL.getValor(), Plano.SEMESTRAL.calcularMensalidade());
        System.out.printf("3. %s  — R$ %.2f total (R$ %.2f/mês)%n",
                Plano.ANUAL.getDescricao(), Plano.ANUAL.getValor(), Plano.ANUAL.calcularMensalidade());

        int opcao = InputHelper.pegarNumInteiro("Opção: ");
        switch (opcao) {
            case 1: return Plano.MENSAL;
            case 2: return Plano.SEMESTRAL;
            case 3: return Plano.ANUAL;
            default: return null;
        }
    }
}