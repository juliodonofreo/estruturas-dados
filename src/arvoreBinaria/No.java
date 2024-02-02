package arvoreBinaria;

public class No<T> {
    private No<T> esquerda;
    private No<T> direita;

    private T valor;

    public No(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return "No{" +
                "valor=" + valor +
                ", esquerda=" + esquerda +
                ", direita=" + direita +
                '}';
    }
}
