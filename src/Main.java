import listaEncadeada.ListaEncadeada;
import pilha.Pilha;

public class Main {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<>("Julio");

        pilha.adicionar("Carla");
        pilha.adicionar("Vitor");
        pilha.adicionar("João");

        System.out.println(pilha);
        System.out.println(pilha.getTopo());
        System.out.println(pilha.getTamanho());

        System.out.println();

        pilha.desempilhar();
        System.out.println(pilha);
        System.out.println(pilha.getTopo());
        System.out.println(pilha.getTamanho());
        System.out.println(pilha.vazia());
    }
}