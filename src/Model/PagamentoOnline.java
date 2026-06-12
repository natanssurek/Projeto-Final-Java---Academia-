package Model;

public class PagamentoOnline extends Pagamento implements Pagavel {
    private String plataforma;
    private double taxaOnline;

    public PagamentoOnline(String id, float valor, String data, boolean status, String plataforma, double taxaOnline) {
        super(id, valor, data, status);
        this.plataforma = plataforma;
        this.taxaOnline = taxaOnline;
    }

    @Override
    public double calcularTotal() {
        return getValor() + this.taxaOnline;
    }

    @Override
    public String tipoPagamento() {
        return "Pagamento online";

    }

    @Override
    public void pagar(double valor) {
        this.setValor(valor);
        this.setStatus(true);
        System.out.println("Pago: " + getStatus());

    }

    @Override
    public void pagar(double valor, String descricao) {
        this.setValor(valor);
        this.setStatus(true);
        System.out.println("Pago: " + getStatus());
        System.out.println("Descricao: " + descricao);

    }

    @Override
    public double calcularValor() {
        return getValor() +  this.taxaOnline;
    }


}
