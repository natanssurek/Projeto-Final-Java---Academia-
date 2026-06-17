package View;

import Controller.AlunoController;
import Controller.MatriculaController;
import Model.Aluno;
import Model.Matricula;
import Model.Plano;
import util.InputHelper;

public class MatriculaView {

    private static MatriculaController matriculaController = new MatriculaController();
    private static AlunoController alunoController = new AlunoController();

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
                case 1 :
                    cadastrar();
                    break;
                case 2 :
                    alterar();
                    break;
                case 3 :
                    deletar();
                    break;
                case 4 :
                    listar();
                    break;
                case 0 :
                    System.out.println("Voltando...");
                    break;
                default :
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
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

        System.out.println("Escolha o Plano Acadêmico:\n1. Mensal (R$ 120,00)\n2. Anual (R$ 1188,00 - R$ 99/mês)");
        int opcaoPlano = InputHelper.pegarNumInteiro("Opção: ");

        Plano planoEscolhido = new Plano();
        planoEscolhido.setAluno(alunoObj.getNome()); // O campo 'aluno' no seu Plano é uma String

        if (opcaoPlano == 2) {
            planoEscolhido.setId("PLN-ANUAL");
            System.out.println("Aplicar desconto de estudante no Plano Anual? (1-Sim / 2-Não)");
            int descOpcao = InputHelper.pegarNumInteiro("Opção: ");

            double valorBase = 1188.0;
            planoEscolhido.setDuracaoMeses(12);
            planoEscolhido.setDescricao("Plano Anual Fit");

            if (descOpcao == 1) {
                double valorComDesconto = planoEscolhido.calcularDesconto(10); // 10% de desconto
                planoEscolhido.setValor(valorComDesconto);
            } else {
                planoEscolhido.setValor(valorBase);
            }
        } else {
            planoEscolhido.setId("PLN-MENSAL");
            planoEscolhido.setValor(120.0);
            planoEscolhido.setDuracaoMeses(1);
            planoEscolhido.setDescricao("Plano Mensal Padrão");
        }

        String dataInicio = InputHelper.pegarTexto("Data de Início (dd/mm/aaaa): ");
        String dataFinal = InputHelper.pegarTexto("Data de Término (dd/mm/aaaa): ");

        Matricula nova = new Matricula(idMatricula, alunoObj, planoEscolhido, dataInicio, dataFinal, true);
        matriculaController.matriculaAluno(nova);

        System.out.println("\nAluno " + alunoObj.getNome() + " matriculado com sucesso!");
        System.out.println("Plano: " + planoEscolhido.getDescricao() + " | Valor Total: R$ " + planoEscolhido.getValor());
        System.out.println("Mensalidade calculada: R$ " + planoEscolhido.calcularMensalidade() + "/mês");
    }

    private static void alterar() {
        System.out.println("\n--- ALTERAR MATRÍCULA ---");
        int id = InputHelper.pegarNumInteiro("Digite o ID da Matrícula: ");
        Matricula mat = matriculaController.buscaPorId(id);

        if (mat != null) {
            System.out.println("Alterando matrícula de: " + mat.getAluno().getNome());
            System.out.println("Plano Atual: " + mat.getPlano().getDescricao());

            System.out.println("Escolha o Novo Plano:1. Mensal2. Anual");
            int opcaoPlano = InputHelper.pegarNumInteiro("Opção: ");

            Plano novoPlano = new Plano();
            novoPlano.setAluno(mat.getAluno().getNome());

            if (opcaoPlano == 2) {
                novoPlano.setId("PLN-ANUAL");
                novoPlano.setValor(1188.0);
                novoPlano.setDuracaoMeses(12);
                novoPlano.setDescricao("Plano Anual Fit");
            } else {
                novoPlano.setId("PLN-MENSAL");
                novoPlano.setValor(120.0);
                novoPlano.setDuracaoMeses(1);
                novoPlano.setDescricao("Plano Mensal Padrão");
            }

            String novaDataInic = InputHelper.pegarTexto("Nova Data de Início: ");
            String novaDataFin = InputHelper.pegarTexto("Nova Data de Término: ");

            matriculaController.alterarMatricula(id, novoPlano, novaDataInic, novaDataFin);
            System.out.println("Matrícula atualizada com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    private static void deletar() {
        int id = InputHelper.pegarNumInteiro("ID da Matrícula para remover: ");
        if (matriculaController.removerMatricula(id)) {
            System.out.println("Matrícula removida!");
        } else {
            System.out.println("Não encontrada.");
        }
    }

    private static void listar() {
        System.out.println("\n--- ALUNOS MATRICULADOS ---");
        if (matriculaController.listarMatriculados().isEmpty()) {
            System.out.println("Nenhuma matrícula ativa.");
            return;
        }
        for (Matricula m : matriculaController.listarMatriculados()) {
            System.out.print("ID Matrícula: " + m.getId());
            System.out.print(" | Aluno: " + m.getAluno().getNome());
            System.out.print(" | Código Plano: " + m.getPlano().getId());
            System.out.print(" | Descrição: " + m.getPlano().getDescricao());
            System.out.print(" | Valor: R$ " + m.getPlano().getValor());
            System.out.println(" | Ativo: " + m.isAtivo());
        }
    }
}