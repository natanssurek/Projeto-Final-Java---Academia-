package Model;

public class PagamentoOnline extends Pagamento implements Pagavel {
    private String plataforma;
    private static final double TAXA_ONLINE = 0.05;
    private double taxaOnline;

    public PagamentoOnline(Aluno aluno, double valor, String data, boolean status, String plataforma) {
        super(aluno, valor, data, status);
        this.plataforma = plataforma;
        this.taxaOnline = TAXA_ONLINE;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getTaxaOnline() {
        return taxaOnline;
    }

    public void setTaxaOnline(double taxaOnline) {
        this.taxaOnline = taxaOnline;
    }

    @Override
    public double calcularTotal() {
        return calcularValor();
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
    public double calcularValor() {
        return getValor() + (getValor() * this.taxaOnline);
    }

    @Override
    public String exibirInfo() {
        return "\n=== PAGAMENTO ONLINE ===" +
                "\nID: " + getId() +
                "\nAluno: " + getAluno().getNome() +
                "\nValor: " + calcularValor() +
                "\nData: " + getData() +
                "\nStatus: " + (getStatus() ? "Pago" : "Pendente") +
                "\nPlataforma: " + plataforma +
                "\nTaxa Online: " + taxaOnline;
    }


}
