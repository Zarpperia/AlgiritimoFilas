import java.util.Scanner;

class Fila {

    private int capacidade;
    private float[] dados;
    private int primeiro;
    private int ultimo;
    private int nItens;

    public Fila(int c) {
        capacidade = c;
        dados = new float[capacidade];
        primeiro = 0;
        ultimo = -1;
        nItens = 0;
    }

    public void inserir(float v) {
        if (ultimo == capacidade - 1)
            ultimo = -1;
        dados[++ultimo] = v;
        nItens++;
    }

    public float remover() {
        float temp = dados[primeiro++];
        if (primeiro == capacidade)
            primeiro = 0;
        nItens--;
        return temp;
    }

    public boolean estaVazia() {
        return (nItens == 0);
    }

    public boolean estaCheia() {
        return (nItens == capacidade);
    }

    public void mostrarFila() {
        int cont, i;
        for (cont = 0, i = primeiro; cont < nItens; cont++) {
            System.out.print(dados[i++] + "\t");
            if (i == capacidade)
                i = 0;
        }
        System.out.println("\n");
    }
}

public class Main {
    public static void main(String[] args) {
        int opcao, capa;
        float valor;
        Scanner scanner = new Scanner(System.in);

        // cria a fila
        System.out.print("\nCapacidade da fila? ");
        capa = scanner.nextInt();
        Fila umaFila = new Fila(capa);

        // apresenta menu
        while (true) {
            System.out.print("\n1 - Inserir elemento\n2 - Remover elemento\n3 - Mostrar Fila\n0 - Sair\n\nOpcao? ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 0:
                    System.exit(0);

                case 1: // insere elemento
                    if (umaFila.estaCheia()) {
                        System.out.println("\nFila Cheia!!!\n\n");
                    } else {
                        System.out.print("\nValor do elemento a ser inserido? ");
                        valor = scanner.nextFloat();
                        umaFila.inserir(valor);
                    }
                    break;

                case 2: // remove elemento
                    if (umaFila.estaVazia()) {
                        System.out.println("\nFila vazia!!!\n\n");
                    } else {
                        valor = umaFila.remover();
                        System.out.println("\n" + valor + " removido com sucesso\n\n");
                    }
                    break;

                case 3: // mostrar fila
                    if (umaFila.estaVazia()) {
                        System.out.println("\nFila vazia!!!\n\n");
                    } else {
                        System.out.print("\nConteudo da fila => ");
                        umaFila.mostrarFila();
                    }
                    break;

                default:
                    System.out.println("\nOpcao Invalida\n\n");
            }
        }
    }
}