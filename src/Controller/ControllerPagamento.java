package Controller;

import Model.Aluno;
import Model.PagamentoOnline;
import Model.PagamentoPresencial;

import java.util.ArrayList;
import java.util.List;

public class ControllerPagamento {

    List <PagamentoOnline> listaPagamentoOnline = new ArrayList<>();
    List <PagamentoPresencial> listaPagamentoPresencial = new ArrayList<>();

    public void cadastrarPagamentoOnline(String nomeAluno, double valor, Aluno aluno, String data, boolean status, String plataforma, double taxaOnline) {
        PagamentoOnline pagamentoOnline = new PagamentoOnline(aluno, valor,  data, status, plataforma, taxaOnline);
        listaPagamentoOnline.add(pagamentoOnline);
    }

    public void cadastrarPagamentoPresencial(String nomeAluno, double valor, Aluno aluno, String data, boolean status, String formaPagamento) {
        PagamentoPresencial pagamentoPresencial = new PagamentoPresencial(aluno, valor, data, status, formaPagamento);
        listaPagamentoPresencial.add(pagamentoPresencial);

    }

    public void alterar(String id, double valor, String data) {
        for (PagamentoOnline listaOnline : listaPagamentoOnline ) {
            if (listaOnline.getId().equals(id)){
                listaOnline.setValor(valor);
                listaOnline.setData(data);
                System.out.println("Informações do pagamento online alteradas com sucesso!");
                return;
            }
        }

        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial ) {
            if(listaPresencial.getId().equals(id)){
                listaPresencial.setValor(valor);
                listaPresencial.setData(data);
                System.out.println("Informações do pagamento presencial alteradas com sucesso!");
                return;
            }
        }
        System.out.println("Pagamento inexistente!");
    }

    public void deletar(String id){
        for (PagamentoOnline listaOnline : listaPagamentoOnline ) {
            if (listaOnline.getId().equals(id)){
                listaPagamentoOnline.remove(listaOnline);
                System.out.println("Pagamento deletado com sucesso!");
                return;
            }
        }

        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial ) {
            if (listaPresencial.getId().equals(id)){
                listaPagamentoPresencial.remove(listaPresencial);
                System.out.println("Pagamento deletado com sucesso!");
                return;
            }
        }
        System.out.println("Pagamento inexistente!");

    }

    public void listarTodos(){
        System.out.println("---> PAGAMENTOS ONLINE <---");
        for (PagamentoOnline listaOnline : listaPagamentoOnline) {
            System.out.println("ID: " + listaOnline.getId());
            System.out.println("Aluno: " + listaOnline.getAluno().getNome());
            System.out.println("Valor: " + listaOnline.getValor());
            System.out.println("Data: " + listaOnline.getData());
            System.out.println("Status: " + listaOnline.getStatus());
            System.out.println("Plataforma: " + listaOnline.getPlataforma());
            System.out.println("TaxaOnline: " + listaOnline.getTaxaOnline());
            System.out.println("----------------------------");
        }

        System.out.println("---> PAGAMENTOS PRESENCIAIS <---");
        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial) {
            System.out.println("ID: " + listaPresencial.getId());
            System.out.println("Aluno: " + listaPresencial.getAluno().getNome());
            System.out.println("Valor: " + listaPresencial.getValor());
            System.out.println("Data: " + listaPresencial.getData());
            System.out.println("Status: " + listaPresencial.getStatus());
            System.out.println("FormaPagamento: " + listaPresencial.getFormaPagamento());
            System.out.println("---------------------------------");
        }
    }

    public void buscarPorId(String id){
        for (PagamentoOnline listaOnline : listaPagamentoOnline) {
            if (listaOnline.getId().equals(id)){
                System.out.println("ID: " + listaOnline.getId());
                System.out.println("Aluno: " + listaOnline.getAluno().getNome());
                System.out.println("Valor: " + listaOnline.getValor());
                System.out.println("Data: " + listaOnline.getData());
                System.out.println("Status: " + listaOnline.getStatus());
                System.out.println("Plataforma: " + listaOnline.getPlataforma());
                System.out.println("TaxaOnline: " + listaOnline.getTaxaOnline());
                return;
            }
        }
        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial) {
            if (listaPresencial.getId().equals(id)){
                System.out.println("ID: " + listaPresencial.getId());
                System.out.println("Aluno: " + listaPresencial.getAluno().getNome());
                System.out.println("Valor: " + listaPresencial.getValor());
                System.out.println("Data: " + listaPresencial.getData());
                System.out.println("Status: " + listaPresencial.getStatus());
                System.out.println("FormaPagamento: " + listaPresencial.getFormaPagamento());
                return;
            }
        }
        System.out.println("Pagamento inexistente!");
    }

    public void listarPorAluno(String nomeAluno){
        for (PagamentoOnline listaOnline : listaPagamentoOnline) {
            if (listaOnline.getAluno().getNome().equals(nomeAluno)){
                System.out.println("ID: " + listaOnline.getId());
                System.out.println("Aluno: " + listaOnline.getAluno().getNome());
                System.out.println("Valor: " + listaOnline.getValor());
                System.out.println("Data: " + listaOnline.getData());
                System.out.println("Status: " + listaOnline.getStatus());
                System.out.println("Plataforma: " + listaOnline.getPlataforma());
                System.out.println("TaxaOnline: " + listaOnline.getTaxaOnline());
                System.out.println("----------------------------");
            }
        }
        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial) {
            if (listaPresencial.getAluno().getNome().equals(nomeAluno)){
                System.out.println("ID: " + listaPresencial.getId());
                System.out.println("Aluno: " + listaPresencial.getAluno().getNome());
                System.out.println("Valor: " + listaPresencial.getValor());
                System.out.println("Data: " + listaPresencial.getData());
                System.out.println("Status: " + listaPresencial.getStatus());
                System.out.println("FormaPagamento: " + listaPresencial.getFormaPagamento());
                System.out.println("---------------------------------");
            }
        }
    }
}
