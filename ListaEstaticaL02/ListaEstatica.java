package ListaEstaticaL02;

public class ListaEstatica<T> {
    private Object[] info;
    private int tamanho;
    
    public ListaEstatica() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] newInfo = (T[])new Object[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            newInfo[i] = info[i];
        }
        info = newInfo;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void inserir(int posicao, T valor) {
        if (posicao < 0) {
            throw new IndexOutOfBoundsException("Posição não pode ser negativa");
        }
        if (tamanho == info.length) {
            redimensionar();
        }
        if (posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição fora do limite");
        }
        for (int i = tamanho; i > posicao; i--) {
            info[i] = info[i - 1];
        }
        info[posicao] = valor;
        tamanho++;
    }

    public void exibir() {
        for (Object XD : info) {
            System.out.println(XD);
        }
    }

    public int buscar(T valor) {
        for (int i = 0; i < info.length; i++) {
            if (valor == info[i]) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int index = buscar(valor);

        if (index == -1) {
            System.out.println("O valor não existe na lista.");
        }        
        if (index > -1) {
			for (int i = index + 1; i < tamanho; i++) {
				info[i-1] = info[i];
			}
			tamanho--;
            System.out.println("Número retirado.");
		}
    }

    public void liberar() {
        Object[] newInfo = new Object[10];
        tamanho = 0;

        info = newInfo;
    }

    public Object obterElemento(int posicao) {
		if (posicao >= 0 && (posicao < tamanho)) {
			return info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

    public boolean estaVazia() {
        if (tamanho == 0) {
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void inverter() {
        int esquerda = 0;
        int direita = tamanho - 1;
        int trocas = tamanho /2;
        T temp = null;

        while (trocas > 0) {
            temp = (T)info[esquerda];
            info[esquerda] = info[direita];
            info[direita] = temp;
            trocas --;
            esquerda++;
            direita--;
        }
    }
}