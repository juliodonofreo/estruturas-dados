import listaEncadeada.ListaEncadeada;
import pilha.Pilha;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada<Pilha<Integer>> lista = new ListaEncadeada<>(new Pilha<>(1));

        lista.get(0).adicionar(2);
        lista.get(0).adicionar(3);

        lista.adicionarNoFinal(new Pilha<>(4));
        lista.get(1).adicionar(5);
        lista.get(1).adicionar(6);
        System.out.println(lista);
    }
}