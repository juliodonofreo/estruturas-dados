import fila.Fila;

public class Main {
    public static void main(String[] args) {

        Fila<Integer> fila = new Fila<>(1);

        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        System.out.println(fila);
        int valor = fila.desenfileirar();
        System.out.println(fila);
        System.out.println(fila.getTopo());
    }
}