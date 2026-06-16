package Controller;

import Model.Aluno;
import Model.PagamentoOnline;
import Model.PagamentoPresencial;

import java.util.ArrayList;
import java.util.List;

public class ControllerPagamento {

    List <PagamentoOnline> listaPagamentoOnline = new ArrayList<>();
    List <PagamentoPresencial> listaPagamentoPresencial = new ArrayList<>();

    public void cadastrarPagamentoOnline(Aluno aluno, String data, boolean status, String plataforma, double taxaOnline) {
        double valor = aluno.getPlano().getValor();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(aluno, valor, data, status, plataforma, taxaOnline);
        listaPagamentoOnline.add(pagamentoOnline);
    }

    public void cadastrarPagamentoPresencial(Aluno aluno, String data, String formaPagamento) {
        double valor = aluno.getPlano().getValor();
        PagamentoPresencial pagamentoPresencial = new PagamentoPresencial(aluno, valor, data, false, formaPagamento);
        listaPagamentoPresencial.add(pagamentoPresencial);
    }

    public void alterar(String id, String data, boolean status) {
        for (PagamentoOnline listaOnline : listaPagamentoOnline) {
            if (listaOnline.getId().equals(id)) {
                listaOnline.setData(data);
                listaOnline.setStatus(status);
                System.out.println("Pagamento online alterado com sucesso!");
                return;
            }
        }

        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial) {
            if (listaPresencial.getId().equals(id)) {
                listaPresencial.setData(data);
                listaPresencial.setStatus(status);
                System.out.println("Pagamento presencial alterado com sucesso!");
                return;
            }
        }
        System.out.println("Pagamento inexistente!");
    }

    public void deletar(String id) {
        boolean removido = listaPagamentoOnline.removeIf(p -> p.getId().equals(id));
        if (removido) {
            System.out.println("Pagamento online deletado com sucesso!");
            return;
        }

        removido = listaPagamentoPresencial.removeIf(p -> p.getId().equals(id));
        if (removido) {
            System.out.println("Pagamento presencial deletado com sucesso!");
            return;
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

    public void exibirPorId(String id) {
        for (PagamentoOnline listaOnline : listaPagamentoOnline) {
            if (listaOnline.getId().equals(id)) {
                System.out.println(listaOnline.exibirInfo());
                return;
            }
        }

        for (PagamentoPresencial listaPresencial : listaPagamentoPresencial) {
            if (listaPresencial.getId().equals(id)) {
                System.out.println(listaPresencial.exibirInfo());
                return;
            }
        }
        System.out.println("Pagamento inexistente!");
    }
}
