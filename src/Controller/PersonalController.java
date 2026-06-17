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

    public PersonalTrainer buscarPorIdPersonal(String id) { // <- String
        for (PersonalTrainer personal : listaPersonais) {
            if (personal.getIdPersonal().equals(id)) { // <- getIdPersonal() e equals()
                return personal;
            }
        }
        return null;
    }

    /// PRETENDO FAZER MAIS MÉTODOS DE BUSCAR COMO: BUSCAR POR CPF, CREF, NOME

    public boolean alterarPersonal(String id, PersonalTrainer personalAtualizado) { // <- String id separado
        PersonalTrainer personalEncontrado = buscarPorIdPersonal(id);

        if (personalEncontrado != null) {
            listaPersonais.remove(personalEncontrado);
            listaPersonais.add(personalAtualizado);
            return true;
        }
        return false;
    }

    public boolean deletarPersonal(String id) { // <- String
        PersonalTrainer personalEncontrado = buscarPorIdPersonal(id);

        if (personalEncontrado != null) {
            listaPersonais.remove(personalEncontrado);
            return true;
        }
        return false;
    }
}