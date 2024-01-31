import listaEncadeada.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        System.out.println(lista);

        lista.adicionarNoFinal(1);
        System.out.println(lista);
        lista.deletarPrimeiro();
        System.out.println(lista);
        lista.adicionarNoFinal(2);
        lista.adicionarNoFinal(3);
        lista.adicionarNoFinal(4);
        System.out.println(lista);

        if(lista.buscar(2)){
            System.out.println("Valor existe na lista");
        }
        else{
            System.out.println("Valor não existe na lista");
        }

        lista.adicionarNoFinal(5);
        System.out.println(lista);
        System.out.println(lista.getTamanho());
        System.out.println(lista.get(2));
        System.out.println(lista.getUltimo());
        lista.deletar(2);
        System.out.println(lista);
        lista.adicionarNoComeco(100);
        lista.adicionarNoComeco(99);
        System.out.println(lista);
        lista.adicionar(3, 255);
        System.out.println(lista);
        lista.ordenar();
        System.out.println(lista);
    }
}