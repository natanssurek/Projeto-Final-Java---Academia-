package Model;

public abstract class Pagamento {

    private String id;
    /*private Aluno aluno;*/
    private float valor;
    private String data;
    private boolean status;

    public Pagamento(String id, float valor, String data, boolean status) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract void calcularTotal();

    public abstract void tipoPagamento();
}
