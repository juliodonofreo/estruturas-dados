package fila;

import listaEncadeada.ListaEncadeada;

import java.util.EmptyStackException;

public class Fila<T extends Comparable<T>> implements Comparable<Fila<T>>{
    private int tamanho;
    private T frente;
    private T topo;

    protected ListaEncadeada<T> lista;

    public Fila(){
        this.tamanho = 0;
        this.frente = null;
        this.topo = null;

        this.lista = new ListaEncadeada<T>();
    }

    public Fila(T objeto){
        if (objeto == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }

        this.tamanho = 1;
        this.topo = objeto;
        this.frente = objeto;

        this.lista = new ListaEncadeada<>(objeto);
    }

    public int getTamanho() {
        return tamanho;
    }

    public T getFrente() {
        return frente;
    }

    public T getTopo() {
        return topo;
    }

    public void enfileirar(T objeto){
        if (objeto == null) throw new IllegalArgumentException("O objeto não pode ser nulo.");

        lista.adicionarNoFinal(objeto);
        tamanho++;
        topo = objeto;
    }

    public boolean vazia(){
        return tamanho == 0;
    }

    public T desenfileirar(){
        if(vazia()){
            throw new EmptyStackException();
        }

        T resultado = lista.deletarPrimeiro();
        tamanho--;
        frente = lista.getPrimeiro();

        return resultado;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    @Override
    public int compareTo(Fila o) {
        return Integer.compare(getTamanho(), o.getTamanho());
    }
}
