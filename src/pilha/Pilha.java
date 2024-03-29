package pilha;
import listaEncadeada.ListaEncadeada;

import java.util.EmptyStackException;

public class Pilha<T extends Comparable<T>> implements Comparable<Pilha<T>>{
    private int tamanho;
    private T topo;

    protected ListaEncadeada<T> lista;

    public Pilha(){
        lista = new ListaEncadeada<>();
        tamanho = 0;
    }

    public Pilha(T objeto){
        if (objeto == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }

        this.tamanho = 1;
        this.topo = objeto;

        lista = new ListaEncadeada<>(objeto);
    }

    public int getTamanho() {
        return tamanho;
    }

    public T getTopo() {
        return topo;
    }

    public void adicionar(T objeto){
        if (objeto == null) throw new IllegalArgumentException("O objeto não pode ser nulo.");


        lista.adicionarNoFinal(objeto);
        tamanho++;
        topo = objeto;
    }

    public boolean vazia(){
        return tamanho == 0;
    }

    public T desempilhar(){
        if(vazia()){
            throw new EmptyStackException();
        }
        T resultado = lista.deletarUltimo();
        tamanho--;

        if(lista.getTamanho() > 0) {
            topo = lista.getUltimo();
        }
        else {
            topo = null;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    @Override
    public int compareTo(Pilha o) {
        return Integer.compare(getTamanho(), o.getTamanho());

    }
}
