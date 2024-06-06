package ListaDuplaEncadeadaL04;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;
    private NoListaDupla<T> ultimo;

    public ListaDupla() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novoNo = new NoListaDupla<>(valor);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> no = buscar(valor);
        if (no == null) {
            System.out.println("O valor não existe na lista.");
            return;
        }

        if (no == primeiro && no == ultimo) { // Único elemento
            primeiro = null;
            ultimo = null;
        } else if (no == primeiro) { // Primeiro elemento
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
        } else if (no == ultimo) { // Último elemento
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
        } else { // Meio da lista
            NoListaDupla<T> anterior = no.getAnterior();
            NoListaDupla<T> proximo = no.getProximo();
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = ultimo;
        while (atual != null) {
            System.out.print(atual.getInfo() + (atual.getAnterior() != null ? ", " : ""));
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
        ultimo = null;
    }

    public ListaDupla<T> criarSubLista(int inicio, int fim) {
        if (inicio < 0 || fim < 0 || inicio > fim) {
            throw new IndexOutOfBoundsException("Índices fora do limite");
        }

        ListaDupla<T> subLista = new ListaDupla<>();
        NoListaDupla<T> atual = primeiro;
        int indice = 0;

        while (atual != null && indice <= fim) {
            if (indice >= inicio) {
                subLista.inserir(atual.getInfo());
            }
            atual = atual.getProximo();
            indice++;
        }
        if (indice <= fim) {
            throw new IndexOutOfBoundsException("Índices fora do limite");
        }
        return subLista;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}

