package arvoreBinaria;

import listaEncadeada.ListaEncadeada;

public class ArvoreBinaria<T extends Comparable<T>> {

    private No<T> raiz;

    public ArvoreBinaria(){}

    public ArvoreBinaria(T valor){
        this.raiz = new No<>(valor);
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

    public void listaParaArvoreBalanceada(ListaEncadeada<T> lista){
        raiz = listaParaArvoreBalanceada(lista, 0, lista.getTamanho() - 1);
    }


    private No<T> listaParaArvoreBalanceada(ListaEncadeada<T> lista, int comeco, int fim){

        if (comeco > fim) {
            return null;
        }

        int metade = (fim + comeco) / 2;
        No<T> no = new No<>(lista.get(metade));
        no.setEsquerda(listaParaArvoreBalanceada(lista, comeco, metade - 1));
        no.setDireita(listaParaArvoreBalanceada(lista, metade + 1, fim));
        return no;
    }


    public void adicionar(T valor){
        if(this.buscar(valor) != null) return;
        if (valor == null) throw new NullPointerException("O valor a se adicionar não pode ser nulo");
        adicionar(raiz, valor);
    }

    private void adicionar(No<T> atual, T valor){
        if (valor.compareTo(atual.getValor()) < 0){
            if (atual.getEsquerda() != null){
                adicionar(atual.getEsquerda(), valor);
            }
            else {
                atual.setEsquerda(new No<>(valor));
            }
        }
        else {
            if (atual.getDireita() != null){
                adicionar(atual.getDireita(), valor);
            }
            else {
                atual.setDireita(new No<>(valor));
            }
        }
    }

    public T remover(T valor) {
        return remover(raiz, valor, null);
    }

    private T remover(No<T> atual, T valor, No<T> anterior) {
        if (atual == null) {
            return null;
        }

        int comparacao = valor.compareTo(atual.getValor());

        if (comparacao < 0) {
            return remover(atual.getEsquerda(), valor, atual);
        } else if (comparacao > 0) {
            return remover(atual.getDireita(), valor, atual);
        } else {
            T valorRemovido = atual.getValor();

            if (atual.getEsquerda() != null && atual.getDireita() != null) {
                No<T> sucessor = encontrarMenor(atual.getDireita());
                atual.setValor(sucessor.getValor());
                remover(atual.getDireita(), sucessor.getValor(), atual);
            } else if (atual.getEsquerda() != null || atual.getDireita() != null) {
                No<T> filho = (atual.getEsquerda() != null) ? atual.getEsquerda() : atual.getDireita();
                if (anterior == null) {
                    raiz = filho;
                } else {
                    if (anterior.getEsquerda().equals(atual)) {
                        anterior.setEsquerda(filho);
                    } else {
                        anterior.setDireita(filho);
                    }
                }
            } else {
                if (anterior == null) {
                    raiz = null;
                } else {
                    if (anterior.getEsquerda().equals(atual)) {
                        anterior.setEsquerda(null);
                    } else {
                        anterior.setDireita(null);
                    }
                }
            }

            return valorRemovido;
        }
    }

    private No<T> encontrarMenor(No<T> atual) {
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }


    public No<T> maisADireita(){
        return maisADireita(raiz);
    }

    private No<T> maisADireita(No<T> atual) {
        if (atual.getDireita() == null){
            return atual;
        }

        return maisADireita(atual.getDireita());
    }

    public No<T> maisAEsquerda(){
        return maisAEsquerda(raiz);
    }

    private No<T> maisAEsquerda(No<T> atual){
        if(atual.getEsquerda() == null){
            return atual;
        }

        return maisAEsquerda(atual.getEsquerda());
    }

    public No<T> buscar(T valor){
        return buscar(raiz, valor);
    }

    private No<T> buscar(No<T> atual, T valor){
        if (atual == null){
            return null;
        }

        if(atual.getValor().equals(valor)){
            return atual;
        }

        if (valor.compareTo(atual.getValor()) < 0){
            return buscar(atual.getEsquerda(), valor);
        }

        return buscar(atual.getDireita(), valor);
    }

    public void preOrdem(){
        preOrdem(raiz);
    }

    private void preOrdem(No<T> atual){
        if (atual == null){
            return;
        }

        System.out.print(atual.getValor() + " ");
        preOrdem(atual.getEsquerda());
        preOrdem(atual.getDireita());
    }

    public void emOrdem(){
        emOrdem(raiz);
    }

    private void emOrdem(No<T> atual){
        if(atual == null){
            return;
        }

        emOrdem(atual.getEsquerda());
        System.out.print(atual.getValor() + " ");
        emOrdem(atual.getDireita());
    }

    public void posOrdem(){
        posOrdem(raiz);
    }

    private void posOrdem(No<T> atual){
        if(atual == null){
            return;
        }

        posOrdem(atual.getEsquerda());
        posOrdem(atual.getDireita());
        System.out.print(atual.getValor() + " ");
    }

    public int profundidade(){
        return profundidade(raiz);
    }

    public int profundidade(No<T> atual){
        if(atual == null){
            return 0;
        }

        int profundidade_esquerda = profundidade(atual.getEsquerda());
        int profundidade_direita = profundidade(atual.getDireita());

        if(profundidade_esquerda > profundidade_direita){
            return 1 + profundidade_esquerda;
        }
        else {
            return 1 + profundidade_direita;
        }
    }

    public ListaEncadeada<T> paraLista(){
        return paraLista(raiz, new ListaEncadeada<T>());
    }

    private ListaEncadeada<T> paraLista(No<T> atual ,ListaEncadeada<T> lista){
        if(atual == null){
            return lista;
        }

        lista = paraLista(atual.getEsquerda(), lista);
        lista.adicionarNoFinal(atual.getValor());
        lista = paraLista(atual.getDireita(), lista);

        return lista;
    }

    public int tamanho(){
        return tamanho(raiz);
    }

    private int tamanho(No<T> atual){
        if(atual == null){
            return 0;
        }

        int tamanhoEsquerda = tamanho(atual.getEsquerda());
        int tamanhoDireita = tamanho(atual.getDireita());

        return tamanhoEsquerda + tamanhoDireita + 1;
    }

    @Override
    public String toString() {
        return "ArvoreBinaria{" +
                "raiz=" + raiz +
                '}';
    }
}
