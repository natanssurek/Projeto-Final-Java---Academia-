package Controller;

import Model.Aluno;
import java.util.ArrayList;

public class AlunoController {

    private ArrayList<Aluno> listaAlunos = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public ArrayList<Aluno> listarTodosAluno() {
        return listaAlunos;
    }

    public Aluno buscarPorIdAluno(int id) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    //PRETENDO FAZER MAIS MÉTODOS DE BUSCAR COMO: BUSCAR POR CPF, MATRÍCULA, NOME

    public boolean alterarAluno(Aluno alunoAtualizado) {
        Aluno alunoEncontrado = buscarPorIdAluno(alunoAtualizado.getId());

        if (alunoEncontrado != null) {
            listaAlunos.remove(alunoEncontrado);
            listaAlunos.add(alunoAtualizado);
            return true;
        }
        return false;
    }

    public boolean deletarAluno(int id) {
        Aluno alunoEncontrado = buscarPorIdAluno(id);

        if (alunoEncontrado != null) {
            listaAlunos.remove(alunoEncontrado);
            return true;
        }
        return false;
    }
}