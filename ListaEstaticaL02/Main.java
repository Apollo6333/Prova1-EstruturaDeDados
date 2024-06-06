package ListaEstaticaL02;

public class Main {
    public static void main(String[] args) {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);

        lista.inserir(2,99);

        lista.inserir(6,70);

        System.out.println(lista.toString());
    }
}
