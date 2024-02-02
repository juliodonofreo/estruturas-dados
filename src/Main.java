import arvoreBinaria.ArvoreBinaria;
import arvoreBinaria.No;
import listaEncadeada.ListaEncadeada;

public class Main {
    public static void main(String[] args) {

        ArvoreBinaria<Integer> arvoreBinaria = new ArvoreBinaria<Integer>(100);
        arvoreBinaria.adicionar(200);
        arvoreBinaria.adicionar(90);
        arvoreBinaria.adicionar(94);
        arvoreBinaria.adicionar(150);
        arvoreBinaria.adicionar(95);
        arvoreBinaria.adicionar(210);
        System.out.println(arvoreBinaria);

        System.out.print("Pré-ordem: ");
        arvoreBinaria.preOrdem();
        System.out.print("\nEm ordem: ");
        arvoreBinaria.emOrdem();
        System.out.print("\nPós ordem: ");
        arvoreBinaria.posOrdem();

        System.out.print("\nProfundidade: " + arvoreBinaria.profundidade());

        System.out.println("\nRemovendo 150: " + arvoreBinaria.remover(150));
        arvoreBinaria.emOrdem();

        No<Integer> num = arvoreBinaria.buscar(100);

        if(num == null){
            System.out.println("\nO valor não foi encontrado. ");
        }
        else{
            System.out.println("\nNó encontrado: " + num);
        }


        ArvoreBinaria<Integer> arvoreBalanceada = new ArvoreBinaria<>();
        ListaEncadeada<Integer> lista = arvoreBinaria.paraLista();
        int tamanho = lista.getTamanho();
        No<Integer> no = arvoreBalanceada.listaParaArvoreBalanceada(lista, 0, tamanho - 1);
        arvoreBalanceada.setRaiz(no);
        System.out.println(no);
        System.out.println(arvoreBalanceada);
        arvoreBalanceada.preOrdem();
    }
}