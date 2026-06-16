package View;

import Controller.AlunoController;
import Controller.PersonalController;
import Controller.TreinoController;
import Model.Aluno;
import Model.PersonalTrainer;
import Model.Treino;
import util.InputHelper;

public class TreinoView {

    private static TreinoController treinoController = new TreinoController();
    private static AlunoController alunoController = new AlunoController();
    private static PersonalController personalController = new PersonalController();

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("===== MENU TREINO =====");
            System.out.println("1. Cadastrar Novo Treino");
            System.out.println("2. Alterar Objetivo de Treino (Mudar Foco)");
            System.out.println("3. Deletar Treino");
            System.out.println("4. Listar Todos os Treinos");
            System.out.println("0. Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> alterarObjetivo();
                case 3 -> deletar();
                case 4 -> listar();
                case 0 -> System.out.println("Voltando...");
            }
        } while (opcao != 0);
    }

    private static void mostrarOpcoesDeTreino() {
        System.out.println("--- OBJETIVOS DISPONÍVEIS ---");
        System.out.println("1. Hipertrofia (Ficar Musculoso)");
        System.out.println("2. Emagrecimento");
        System.out.println("3. Definição Muscular");
        System.out.println("4. Resistência Muscular");
        System.out.println("5. Treino Funcional");
        System.out.println("6. Força Bruta");
        System.out.println("7. Recuperação/Mobilidade");
    }

    private static void cadastrar() {
        System.out.println("\n--- CADASTRAR NOVO TREINO ---");
        int id = InputHelper.pegarNumInteiro("ID do Treino: ");
        if (id == -1) return;

        int idAluno = InputHelper.pegarNumInteiro("ID do Aluno: ");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        int idPersonal = InputHelper.pegarNumInteiro("ID do Personal Trainer: ");
        PersonalTrainer personal = personalController.buscarPorIdPersonal(idPersonal);
        if (personal == null) {
            System.out.println("Personal Trainer não encontrado!");
            return;
        }

        String data = InputHelper.pegarTexto("Data do Treino (dd/mm/aaaa): ");

        mostrarOpcoesDeTreino();
        int tipoEscolhido = InputHelper.pegarNumInteiro("Escolha o número do Objetivo para o aluno: ");

        Treino novoTreino = new Treino(id, aluno, personal, data, "Padrão", 0, "A definir");
        treinoController.cadastrarTreino(novoTreino);

        if (treinoController.mudarObjetivoTreino(id, tipoEscolhido)) {
            System.out.println("Treino montado e customizado automaticamente com sucesso!");
        } else {
            System.out.println("Erro ao definir o tipo.");
        }
    }

    private static void alterarObjetivo() {
        System.out.println("\n--- ALTERAR OBJETIVOS DO TREINO ---");
        int id = InputHelper.pegarNumInteiro("Digite o ID do Treino que deseja mudar: ");
        Treino treinoExistente = treinoController.buscarPorId(id);

        if (treinoExistente != null) {
            System.out.println("Treino Atual: " + treinoExistente.getTipo() + " | Aluno: " + treinoExistente.getAluno().getNome());

            String novaData = InputHelper.pegarTexto("Deseja atualizar a data do treino? Digite a nova data: ");
            treinoController.alterarTreinoDados(id, novaData);

            mostrarOpcoesDeTreino();
            int novoObjetivo = InputHelper.pegarNumInteiro("Escolha o Novo Objetivo do Aluno: ");

            if (treinoController.mudarObjetivoTreino(id, novoObjetivo)) {
                System.out.println("Sucesso! O tipo de treino, tempo e rotina foram modificados.");
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    private static void deletar() {
        int id = InputHelper.pegarNumInteiro("ID do Treino para exclusão: ");
        if (treinoController.removerTreino(id)) {
            System.out.println("Treino deletado.");
        } else {
            System.out.println("ID inválido.");
        }
    }

    private static void listar() {
        System.out.println("\n--- LISTA GERAL DE TREINOS ---");
        if (treinoController.listarTreinos().isEmpty()) {
            System.out.println("Nenhum treino montado ainda.");
            return;
        }
        for (Treino t : treinoController.listarTreinos()) {
            System.out.println("----------------------------------------");
            System.out.println("Treino ID: " + t.getId() + " | Data: " + t.getData());
            System.out.println("Aluno: " + t.getAluno().getNome());
            System.out.println("Personal: " + t.getPersonalTrainer().getNome());
            System.out.println("Foco Acadêmico: " + t.getTipo());
            System.out.println("Duração Estimada: " + t.getDuracaoMinutos() + " minutos");
            System.out.println("Rotina Proposta: " + t.getObservacoes());
        }
    }
}