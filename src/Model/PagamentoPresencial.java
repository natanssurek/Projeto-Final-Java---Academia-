package Model;

public class PagamentoPresencial extends Pagamento implements Pagavel{
    private String formaPagamento;

    public PagamentoPresencial(Aluno aluno, double valor, String data, boolean status, String formaPagamento) {
        super(aluno, valor, data, status);
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public double calcularTotal() {
        return getValor();
    }

    @Override
    public String tipoPagamento() {
        return "Pagamento Presencial";
    }

    @Override
    public void pagar(double valor) {
        this.setValor(valor);
        this.setStatus(true);
        System.out.println("Pago: " + this.getStatus());
    }

    @Override
    public void pagar(double valor, String descricao) {
        this.setValor(valor);
        this.setStatus(true);
        System.out.println("Pago: " + this.getStatus());
    }

    @Override
    public double calcularValor() {
        return getValor();
    }
}
