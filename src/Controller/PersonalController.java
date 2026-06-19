package Controller;

import Model.PersonalTrainer;
import java.util.ArrayList;

public class PersonalController {

    private ArrayList<PersonalTrainer> listaPersonais = new ArrayList<>();

    public void cadastrarPersonal(PersonalTrainer personal) {
        listaPersonais.add(personal);
    }

    public ArrayList<PersonalTrainer> listarTodosPersonal() {
        return listaPersonais;
    }

    public PersonalTrainer buscarPorIdPersonal(String id) {
        for (PersonalTrainer personal : listaPersonais) {
            if (personal.getIdPersonal().equals(id)) {
                return personal;
            }
        }
        return null;
    }

    public PersonalTrainer buscarPorCPFPersonal(String cpf) {
        for (PersonalTrainer personal : listaPersonais) {
            if (personal.getCpf().equals(cpf)) {
                return personal;
            }
        }
        return null;
    }

    public PersonalTrainer buscarPorCrefPersonal(String cref) {
        for (PersonalTrainer personal : listaPersonais) {
            if (personal.getCref().equals(cref)) {
                return personal;
            }
        }
        return null;
    }

    public void alterarPersonal(String id, PersonalTrainer personalAtualizado) {
        PersonalTrainer personalEncontrado = buscarPorIdPersonal(id);

        if (personalEncontrado != null) {
            personalEncontrado.setNome(personalAtualizado.getNome());
            personalEncontrado.setEmail(personalAtualizado.getEmail());
            personalEncontrado.setTelefone(personalAtualizado.getTelefone());
            personalEncontrado.setCref(personalAtualizado.getCref());
            personalEncontrado.setEspecialidade(personalAtualizado.getEspecialidade());
        }
    }

    public void alterarPersonal(String cpf, PersonalTrainer personalAtualizado, boolean porCpf) {
        PersonalTrainer personalEncontrado = buscarPorCPFPersonal(cpf);

        if (personalEncontrado != null) {
            personalEncontrado.setNome(personalAtualizado.getNome());
            personalEncontrado.setEmail(personalAtualizado.getEmail());
            personalEncontrado.setTelefone(personalAtualizado.getTelefone());
            personalEncontrado.setCref(personalAtualizado.getCref());
            personalEncontrado.setEspecialidade(personalAtualizado.getEspecialidade());
        }
    }

    public void deletarPersonal(PersonalTrainer personal) {
        listaPersonais.remove(personal);
    }
}