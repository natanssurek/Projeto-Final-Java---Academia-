package Controller;

import Model.Matricula;

import java.util.ArrayList;
import java.util.List;

public class MatriculaController {

    private List<Matricula> alunosMatriculados = new ArrayList<>();

    public void cadastrarMatricula(Matricula matricula) {
        alunosMatriculados.add(matricula);
    }

    public boolean removerMatricula(String id) {
        return alunosMatriculados.removeIf(m -> m.getId().equals(id));
    }

    public List<Matricula> listarMatriculados() {
        return alunosMatriculados;
    }

    public Matricula buscaPorId(String id) {
        for (Matricula m : alunosMatriculados) {
            if (m.getId().equals(id)) {
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