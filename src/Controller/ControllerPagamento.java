package Controller;

import Model.Aluno;
import Model.Pagamento;
import Model.PagamentoOnline;
import Model.PagamentoPresencial;

import java.util.ArrayList;
import java.util.List;

public class ControllerPagamento {

    List<PagamentoOnline> listaPagamentoOnline = new ArrayList<>();
    List<PagamentoPresencial> listaPagamentoPresencial = new ArrayList<>();

    public void cadastrarPagamentoOnline(Aluno aluno, String data, String plataforma) {
        double valor = aluno.getPlano().getValor();
        PagamentoOnline pagamentoOnline = new PagamentoOnline(aluno, valor, data, false, plataforma);
        listaPagamentoOnline.add(pagamentoOnline);
    }

    public void cadastrarPagamentoPresencial(Aluno aluno, String data, String formaPagamento) {
        double valor = aluno.getPlano().getValor();
        PagamentoPresencial pagamentoPresencial = new PagamentoPresencial(aluno, valor, data, false, formaPagamento);
        listaPagamentoPresencial.add(pagamentoPresencial);
    }

    public boolean alterar(String id, String data, boolean status) {
        for (PagamentoOnline p : listaPagamentoOnline) {
            if (p.getId().equals(id)) {
                p.setData(data);
                p.setStatus(status);
                return true;
            }
        }
        for (PagamentoPresencial p : listaPagamentoPresencial) {
            if (p.getId().equals(id)) {
                p.setData(data);
                p.setStatus(status);
                return true;
            }
        }
        return false;
    }

    public boolean deletar(String id) {
        return listaPagamentoOnline.removeIf(p -> p.getId().equals(id)) ||
                listaPagamentoPresencial.removeIf(p -> p.getId().equals(id));
    }

    public List<PagamentoOnline> getListaPagamentoOnline() {
        return listaPagamentoOnline;
    }

    public List<PagamentoPresencial> getListaPagamentoPresencial() {
        return listaPagamentoPresencial;
    }

    public Pagamento buscarPorId(String id) {
        for (PagamentoOnline p : listaPagamentoOnline) {
            if (p.getId().equals(id)) return p;
        }
        for (PagamentoPresencial p : listaPagamentoPresencial) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Pagamento> listarPorAluno(String nomeAluno) {
        List<Pagamento> resultado = new ArrayList<>();
        for (PagamentoOnline p : listaPagamentoOnline) {
            if (p.getAluno().getNome().equals(nomeAluno)) resultado.add(p);
        }
        for (PagamentoPresencial p : listaPagamentoPresencial) {
            if (p.getAluno().getNome().equals(nomeAluno)) resultado.add(p);
        }
        return resultado;
    }
}
