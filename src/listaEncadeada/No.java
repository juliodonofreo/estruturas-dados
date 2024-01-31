package listaEncadeada;

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
}
