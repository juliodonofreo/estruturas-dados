package listaEncadeada;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListaEncadeadaIterator<T extends Comparable<T>> implements Iterator<T> {

    private No<T> atual;

    public ListaEncadeadaIterator(No<T> primeiro) {
        this.atual = primeiro;
    }

    @Override
    public boolean hasNext() {
        return atual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não há mais elementos na lista.");
        }

        T valor = atual.getValor();
        atual = atual.getProximo();
        return valor;
    }
}
