package listaEncadeada;

import java.util.Objects;

class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo(){
        return this.proximo;
    }

    public void setProximo(No<T> proximo) {
        if (proximo == null){
            this.proximo = null;
            return;
        }
        this.proximo = proximo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof No<?> no)) return false;
        return Objects.equals(getValor(), no.getValor()) && Objects.equals(getProximo(), no.getProximo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValor(), getProximo());
    }
}
