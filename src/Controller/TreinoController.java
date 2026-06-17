package Controller;

import Model.Treino;
import java.util.ArrayList;
import java.util.List;

public class TreinoController {

    private static List<Treino> listaTreinos = new ArrayList<>();

    public void cadastrarTreino(Treino treino) {
        listaTreinos.add(treino);
    }

    public boolean removerTreino(int id) {
        return listaTreinos.removeIf(t -> t.getId() == id);
    }

    public boolean alterarTreinoDados(int id, String novaData) {
        Treino treinoExistente = buscarPorId(id);
        if (treinoExistente != null) {
            treinoExistente.setData(novaData);
            return true;
        }
        return false;
    }

    public boolean mudarObjetivoTreino(int id, int opcaoObjetivo) {
        Treino t = buscarPorId(id);
        if (t == null) return false;

        switch (opcaoObjetivo) {
            case 1 -> {
                t.setTipo("Hipertrofia (Musculoso)");
                t.setDuracaoMinutos(60);
                t.setObservacoes("Foco em progressão de carga. 4 séries de 8 a 12 repetições até a falha.");
            }
            case 2 -> {
                t.setTipo("Emagrecimento (Cardio/Hiit)");
                t.setDuracaoMinutos(45);
                t.setObservacoes("Treino de alta intensidade com descansos curtos (30s) e esteira pós-treino.");
            }
            case 3 -> {
                t.setTipo("Definição Muscular");
                t.setDuracaoMinutos(50);
                t.setObservacoes("Séries conjugadas (Bi-sets) combinando força com estímulo aeróbico contínuo.");
            }
            case 4 -> {
                t.setTipo("Resistência Muscular");
                t.setDuracaoMinutos(70);
                t.setObservacoes("Cargas moderadas, foco em altas repetições (15 a 20 por série).");
            }
            case 5 -> {
                t.setTipo("Treino Funcional");
                t.setDuracaoMinutos(40);
                t.setObservacoes("Foco em estabilidade do core, agilidade e movimentos multiarticulares.");
            }
            case 6 -> {
                t.setTipo("Força Bruta (Powerlifting)");
                t.setDuracaoMinutos(65);
                t.setObservacoes("Baixas repetições (3 a 5), cargas altíssimas e descanso longo (2 a 3 min).");
            }
            case 7 -> {
                t.setTipo("Recuperação Ativa / Mobilidade");
                t.setDuracaoMinutos(30);
                t.setObservacoes("Foco em alongamentos dinâmicos, liberação miofascial e exercícios posturais.");
            }
            default -> { return false; }
        }
        return true;
    }

    public List<Treino> listarTreinos() {
        return listaTreinos;
    }

    public Treino buscarPorId(int id) {
        for (Treino t : listaTreinos) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public List<Treino> buscarPorAluno(String nomeAluno) {
        List<Treino> treinosDoAluno = new ArrayList<>();
        for (Treino t : listaTreinos) {
            if (t.getAluno() != null && t.getAluno().getNome().equalsIgnoreCase(nomeAluno)) {
                treinosDoAluno.add(t);
            }
        }
        return treinosDoAluno;
    }
}