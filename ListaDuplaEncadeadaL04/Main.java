package ListaDuplaEncadeadaL04;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Integer> lista1 = new ListaDupla<>();

        lista1.inserir(10);
        lista1.inserir(20);
        lista1.inserir(30);
        lista1.inserir(40);
        lista1.inserir(50);
        lista1.inserir(60);
        lista1.inserir(70);
        
        System.out.println("Lista: ");
        System.out.println(lista1.toString());

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2, 6);

        System.out.println("Sublista: " + lista2.toString());
    }  
}
