package Model;

public interface Pagavel {

    void pagar (double valor);
    void pagar (double valor, String descricao);
    double calcularValor ();


}
