package Controller;

import Model.PagamentoOnline;
import Model.PagamentoPresencial;

import java.util.ArrayList;
import java.util.List;

public class ControllerPagamento {

    List <PagamentoOnline> listaPagamentoOnline = new ArrayList<>();
    List <PagamentoPresencial> listaPagamentoPresencial = new ArrayList<>();

    public void cadastrarPagamentoOnline(String id, double valor, String data, boolean status, String plataforma, double taxaOnline) {
        PagamentoOnline pagamentoOnline = new PagamentoOnline(id, valor, data, status, plataforma, taxaOnline);
        listaPagamentoOnline.add(pagamentoOnline);
    }

    public void cadastrarPagamentoPresencial(String id, double valor, String data, boolean status, String formaPagamento) {
        PagamentoPresencial pagamentoPresencial = new PagamentoPresencial(id, valor, data, status, formaPagamento);
        listaPagamentoPresencial.add(pagamentoPresencial);

    }

    public void alterar(){

    }

    public void deletar(){

    }

    public void listarTodos(){

    }

    public void buscarPorId(){

    }

    public void listarPorAluno(){

    }
}
