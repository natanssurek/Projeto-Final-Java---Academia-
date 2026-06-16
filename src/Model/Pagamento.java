package Model;

public abstract class Pagamento {
    private static int contador = 1;
    private String id;
    private Aluno aluno;
    private double valor;
    private String data;
    private boolean status;


    public Pagamento(Aluno aluno, double valor, String data, boolean status) {
        this.id = "PAG" + contador++;
        this.aluno = aluno;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract double calcularTotal();

    public abstract String tipoPagamento();
}
