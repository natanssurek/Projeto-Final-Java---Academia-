package Model;

public class Plano implements Calculavel {

    public static final Plano MENSAL = new Plano("MENSAL", 100.00, 1);
    public static final Plano SEMESTRAL = new Plano("SEMESTRAL", 500.00, 6);
    public static final Plano ANUAL = new Plano("ANUAL", 900.00, 12);

    private String descricao;
    private double valor;
    private int duracaoMeses;

    private Plano(String descricao, double valor, int duracaoMeses) {
        this.descricao = descricao;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
    }

    @Override
    public double calcularMensalidade() {
        if (this.duracaoMeses == 0) {
            return 0;
        }
        return this.valor / this.duracaoMeses;
    }

    @Override
    public double calcularDesconto(double desconto) {
        return this.valor - (this.valor * desconto / 100);
    }

    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public int getDuracaoMeses() { return duracaoMeses; }
}