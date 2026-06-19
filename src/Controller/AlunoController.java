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

    public Aluno buscarPorIdAluno(String id) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getIdAluno().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno buscarPorCPFAluno(String cpf) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void alterarAlunoPorId(String id, Aluno alunoAtualizado) {
        Aluno alunoEncontrado = buscarPorIdAluno(id);

        if (alunoEncontrado != null) {
            alunoEncontrado.setNome(alunoAtualizado.getNome());
            alunoEncontrado.setEmail(alunoAtualizado.getEmail());
            alunoEncontrado.setTelefone(alunoAtualizado.getTelefone());
            alunoEncontrado.setMatricula(alunoAtualizado.getMatricula());
            alunoEncontrado.setObjetivo(alunoAtualizado.getObjetivo());
            alunoEncontrado.setPlano(alunoAtualizado.getPlano());
        }
    }

    public void alterarAlunoPorCpf(String cpf, Aluno alunoAtualizado) {
        Aluno alunoEncontrado = buscarPorCPFAluno(cpf);

        if (alunoEncontrado != null) {
            alunoEncontrado.setNome(alunoAtualizado.getNome());
            alunoEncontrado.setEmail(alunoAtualizado.getEmail());
            alunoEncontrado.setTelefone(alunoAtualizado.getTelefone());
            alunoEncontrado.setMatricula(alunoAtualizado.getMatricula());
            alunoEncontrado.setObjetivo(alunoAtualizado.getObjetivo());
            alunoEncontrado.setPlano(alunoAtualizado.getPlano());
        }
    }

    public void deletarAluno(String id) {
        Aluno alunoEncontrado = buscarPorIdAluno(id);

        if (alunoEncontrado != null) {
            listaAlunos.remove(alunoEncontrado);
        }
    }
}