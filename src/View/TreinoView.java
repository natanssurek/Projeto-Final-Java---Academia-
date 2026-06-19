package View;

import Controller.AlunoController;
import Controller.PersonalController;
import Controller.TreinoController;
import Model.Aluno;
import Model.PersonalTrainer;
import Model.Treino;
import util.InputHelper;

public class TreinoView {

    private AlunoController alunoController;
    private PersonalController personalController;
    private TreinoController treinoController;

    public TreinoView(AlunoController alunoController, PersonalController personalController, TreinoController treinoController) {
        this.alunoController = alunoController;
        this.personalController = personalController;
        this.treinoController = treinoController;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("===== MENU TREINO =====");
            System.out.println("1. Cadastrar Novo Treino");
            System.out.println("2. Alterar Objetivo de Treino (Mudar Foco)");
            System.out.println("3. Deletar Treino");
            System.out.println("4. Listar Todos os Treinos");
            System.out.println("6. Voltar");

            opcao = InputHelper.pegarNumInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: alterarTreinos(); break;
                case 3: deletar(); break;
                case 4: listar(); break;
                case 6: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
        } while (opcao != 6);
    }

    private void mostrarOpcoesDeTreino() {
        System.out.println("--- OBJETIVOS DISPONÍVEIS ---");
        System.out.println("1. Ficar Musculoso");
        System.out.println("2. Emagrecimento");
        System.out.println("3. Definição Muscular");
        System.out.println("4. Resistência Muscular");
        System.out.println("5. Treino Funcional");
        System.out.println("6. Força Bruta");
        System.out.println("7. Recuperação/Mobilidade");
    }

    private void cadastrar() {
        System.out.println("--- CADASTRAR NOVO TREINO ---");

        String idAluno = InputHelper.pegarTexto("ID do Aluno (ex: ALUNO-1): ");
        Aluno aluno = alunoController.buscarPorIdAluno(idAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        String idPersonal = InputHelper.pegarTexto("ID do Personal (ex: PERSONAL-1): ");
        PersonalTrainer personal = personalController.buscarPorIdPersonal(idPersonal);
        if (personal == null) {
            System.out.println("Personal Trainer não encontrado!");
            return;
        }

        String data = InputHelper.pegarTexto("Data do Treino (dd/mm/aaaa): ");

        mostrarOpcoesDeTreino();
        int tipoEscolhido = InputHelper.pegarNumInteiro("Escolha o número do Objetivo para o aluno: ");

        Treino novoTreino = new Treino(aluno, personal, data, "Padrão", 0, "A definir");
        treinoController.cadastrarTreino(novoTreino);

        if (treinoController.mudarObjetivoTreino(novoTreino.getId(), tipoEscolhido)) {
            System.out.println("Treino montado e customizado automaticamente com sucesso!");
        } else {
            System.out.println("Erro ao definir o tipo.");
        }
    }

    private void alterarTreinos() {
        System.out.println("--- ALTERAR OBJETIVOS DO TREINO ---");
        String id = InputHelper.pegarTexto("ID do Treino (ex: TREINO-1): ");
        Treino treinoExistente = treinoController.buscarPorId(id);

        if (treinoExistente == null) {
            System.out.println("Treino não encontrado.");
            return;
        }

        System.out.println("Treino Atual: " + treinoExistente.getTipo() + " | Aluno: " + treinoExistente.getAluno().getNome());

        String novaData = InputHelper.pegarTexto("Nova data do treino: ");
        treinoController.alterarTreinoDados(id, novaData);

        mostrarOpcoesDeTreino();
        int novoObjetivo = InputHelper.pegarNumInteiro("Escolha o Novo Objetivo do Aluno: ");

        if (treinoController.mudarObjetivoTreino(id, novoObjetivo)) {
            System.out.println("Sucesso! O tipo de treino, tempo e rotina foram modificados.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private void deletar() {
        String id = InputHelper.pegarTexto("ID do Treino (ex: TREINO-1): ");
        if (treinoController.removerTreino(id)) {
            System.out.println("Treino deletado.");
        } else {
            System.out.println("ID inválido.");
        }
    }

    private void listar() {
        System.out.println("--- LISTA GERAL DE TREINOS ---");
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