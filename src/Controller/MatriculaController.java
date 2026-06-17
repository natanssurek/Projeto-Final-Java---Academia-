package Controller;

import Model.Matricula;
import Model.Plano;
import java.util.ArrayList;
import java.util.List;

public class MatriculaController {

    private static List<Matricula> alunosMatriculados = new ArrayList<>();

    public void matriculaAluno(Matricula matricula) {
        alunosMatriculados.add(matricula);
    }

    public boolean alterarMatricula(int id, Plano novoPlano, String novaDataInicio, String novaDataFinal) {
        Matricula matriculaExistente = buscaPorId(id);

        if (matriculaExistente != null) {
            matriculaExistente.setPlano(novoPlano);
            matriculaExistente.setDataInicio(novaDataInicio);
            matriculaExistente.setDataFinal(novaDataFinal);
            return true;
        }
        return false;
    }

    public boolean removerMatricula(int id) {
        return alunosMatriculados.removeIf(m -> m.getId() == id);
    }

    public List<Matricula> listarMatriculados() {
        return alunosMatriculados;
    }

    public Matricula buscaPorId(int id) {
        for (Matricula m : alunosMatriculados) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public Matricula buscarPorAluno(String nomeAluno) {
        for (Matricula m : alunosMatriculados) {
            if (m.getAluno().getNome().equalsIgnoreCase(nomeAluno)) {
                return m;
            }
        }
        return null;
    }
}