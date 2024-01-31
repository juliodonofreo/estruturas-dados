package listaEncadeada;

import java.util.Iterator;
import java.util.Objects;

public class ListaEncadeada<T extends Comparable<T>> implements Iterable<T>{

    private No<T> primeiro;

    public ListaEncadeada(){
        this.primeiro = null;
    }

    public ListaEncadeada(T valor){
        this.primeiro = new No<T>(valor);
    }

    public No<T> getPrimeiro(){
        return this.primeiro;
    }

    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    public boolean buscar(T valor){
        return buscar(this.primeiro, valor);
    }

    private boolean buscar(No<T> atual, T valor){
        if(atual == null) return false;
        if(atual.getValor().equals(valor)) return true;
        return buscar(atual.getProximo(), valor);
    }

    public T getUltimo(){
        return this.get(this.getTamanho() - 1);
    }

    public int getTamanho(){
        if (this.primeiro == null) return 0;
        No<T> atual = this.primeiro;
        int tamanho = 1;
        while (atual.getProximo() != null){
            atual = atual.getProximo();
            tamanho++;
        }
        return tamanho;
    }

    public T get(int index){
        if (index < 0) throw new IndexOutOfBoundsException("O índice não pode ser negativo. ");
        if(index >= getTamanho()) throw new IndexOutOfBoundsException("Indice grande demais. ");
        if(index == 0) return this.primeiro.getValor();

        No<T> valor = this.primeiro;
        int contagem = 0;
        while (contagem != index){
            valor = valor.getProximo();
            contagem++;
        }
        return valor.getValor();

    }

    public T deletarPrimeiro(){
        T valor = this.primeiro.getValor();
        this.primeiro = this.primeiro.getProximo();
        return valor;
    }

    public T deletar(int index){
        if (index < 0) throw new IndexOutOfBoundsException("O índice não pode ser negativo. ");
        if(index >= getTamanho()) throw new IndexOutOfBoundsException("Indice grande demais. ");
        if(index == 0) return this.primeiro.getValor();

        No<T> valor = this.primeiro;
        No<T> anterior = null;
        int contagem = 0;
        while (contagem != index){
            anterior = valor;
            valor = valor.getProximo();
            contagem++;
        }
        anterior.setProximo(valor.getProximo());
        return valor.getValor();
    }

    public T deletarUltimo(){
        if (this.getTamanho() == 1){
            T valor = this.primeiro.getValor();
            this.primeiro = null;
            return valor;
        }
        No<T> atual = this.primeiro;
        No<T> anterior = null;

        while (atual.getProximo() != null){
            anterior = atual;
            atual = atual.getProximo();
        }

        assert anterior != null;
        anterior.setProximo(null);
        return atual.getValor();
    }

    public void ordenar(){
        No<T> anterior = null;
        No<T> atual = primeiro;
        No<T> proximo = atual.getProximo();

        while (proximo != null) {
            if (atual.getValor().compareTo(proximo.getValor()) > 0) {
                if (anterior == null) {
                    primeiro = proximo;
                } else {
                    anterior.setProximo(proximo);
                }

                atual.setProximo(proximo.getProximo());
                proximo.setProximo(atual);

                anterior = null;
                atual = primeiro;
                proximo = atual.getProximo();
            } else {
                anterior = atual;
                atual = proximo;
                proximo = proximo.getProximo();
            }
        }
    }

    public void adicionarNoComeco(T valor){
        No<T> primeiroAntigo = this.primeiro;
        this.primeiro = new No<>(valor);
        this.primeiro.setProximo(primeiroAntigo);
    }

    public void adicionar(int index, T valor){
        if (index < 0) throw new IndexOutOfBoundsException("O índice não pode ser negativo. ");
        if(index >= getTamanho()) throw new IndexOutOfBoundsException("Indice grande demais. ");

        if(index == 0) {
            this.adicionarNoComeco(valor);
        }

        No<T> atual = this.primeiro;
        No<T> anterior = null;
        int contagem = 0;
        while (contagem != index){
            anterior = atual;
            atual = atual.getProximo();
            contagem++;
        }
        anterior.setProximo(new No<>(valor));
        anterior.getProximo().setProximo(atual);


    }

    public void adicionarNoFinal(T valor){
        if (this.primeiro == null) {
            this.primeiro = new No<>(valor);
            return;
        }
        No<T> atual = primeiro;
        while (atual.getProximo() != null){
            atual = atual.getProximo();
        }
        atual.setProximo(new No<>(valor));
    }

    public void limpar(){
        this.primeiro = null;
    }

    @Override
    public String toString() {
        if(this.primeiro == null) return  "[]";
        StringBuilder resultado = new StringBuilder("[");
        No<T> atual = primeiro;

        do{
            resultado.append((atual.getProximo() != null) ? atual.getValor() + ", " : atual.getValor());
            atual = atual.getProximo();
        }while (atual != null);

        resultado.append("]");
        return resultado.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaEncadeada<?> that)) return false;
        return Objects.equals(getPrimeiro(), that.getPrimeiro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimeiro());
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaEncadeadaIterator<T>(this.primeiro);
    }
}