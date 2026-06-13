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

    public PersonalTrainer buscarPorIdPersonal(int id) {
        for (PersonalTrainer personal : listaPersonais) {
            if (personal.getId() == id) {
                return personal;
            }
        }
        return null;
    }

    /// PRETENDO FAZER MAIS MÉTODOS DE BUSCAR COMO: BUSCAR POR CPF, CREF, NOME

    public boolean alterarPersonal(PersonalTrainer personalAtualizado) {
        PersonalTrainer personalEncontrado = buscarPorIdPersonal(personalAtualizado.getId());

        if (personalEncontrado != null) {
            listaPersonais.remove(personalEncontrado);
            listaPersonais.add(personalAtualizado);
            return true;
        }
        return false;
    }

    public boolean deletarPersonal(int id) {
        PersonalTrainer personalEncontrado = buscarPorIdPersonal(id);

        if (personalEncontrado != null) {
            listaPersonais.remove(personalEncontrado);
            return true;
        }

        return false;
    }
}