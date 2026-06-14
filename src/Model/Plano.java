package Model;

public class Plano implements Calculavel {
    private String id;
    private String aluno;
    private double valor;
    private int duracaoMeses;
    private String descricao;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAluno() {
        return aluno;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
