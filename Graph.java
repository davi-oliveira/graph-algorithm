import java.util.Scanner;

class Graph {
    static int[][] graph;

    /*
     * >> CORES
     */
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";

    public static void printGraph() {
        for (int l = 0; l < graph.length; l++) {
            System.out.print((l != 0 ? SystemUtil.textWithColor(l, ANSI_YELLOW) : " ") + "\t");
            for (int c = 1; c < graph.length; c++) {
                if (l == c)
                    System.out.print(SystemUtil.textWithColor("XX", ANSI_RED));
                else
                    System.out.print(l == 0 ? SystemUtil.textWithColor(c, ANSI_YELLOW) : graph[l][c]);

                System.out.print("\t");
            }
            System.out.print("\n");
        }
        SystemUtil.waitUser();
    }

    public static int findRoute(int inicio, int fim) {
        int soma = 0;

        System.out.println("--> " + inicio);

        if (graph[inicio][fim] != 0) {
            System.out.println("--> " + fim);
            return graph[inicio][fim];
        }

        if (inicio <= 9) {
            int proximo = inicio;

            do {
                proximo++;
            } while (graph[inicio][proximo] == 0);

            soma += graph[inicio][proximo] + findRoute(proximo, fim);
        }
        return soma;

    }

    public static void initializeGraph(int ordem) {
        graph = new int[ordem + 1][ordem + 1];
        SystemUtil.fillWithNought(graph);
        SystemUtil.notifyUser("Grafo criado com sucesso!!");
    }

    public static void insertVertex(int conteudo, int linha, int coluna) {
        graph[linha][coluna] = conteudo;
        graph[coluna][linha] = conteudo;
        SystemUtil.notifyUser(String.format("Vertice de valor %d criado com sucesso na posicao [%d, %d]",
                conteudo, linha, coluna));
    }

    public static int showMenu() {
        SystemUtil.clearTerminal();
        System.out.println("|_____________ Menu _____________|");
        System.out.println("1 - Inicializar grafo");
        System.out.println("2 - Mostrar grafo atual");
        System.out.println("3 - Preencher com dados de exemplo 1  (ord. 12)");
        System.out.println("4 - Preencher com dados de exemplo 2 (ord. 6)");
        System.out.println("5 - Inserir vertice");
        System.out.println("6 - Encontrar rota aleatoria");
        System.out.println("8 - Sair do programa");
        System.out.print("\nDigite a opcao desejada: ");

        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static void main(String[] args) {
        int option = -1;
        Scanner scan = new Scanner(System.in);
        do {
            option = showMenu();

            if (option == 1) {
                System.out.println("Qual a ordem do grafo? ");
                int ordem = scan.nextInt();
                initializeGraph(ordem);
            } else if (option == 2) {
                SystemUtil.clearTerminal();
                printGraph();
            } else if (option == 3) {
                if (SystemUtil.exampleData(graph))// se foi preenchido corretamente
                    SystemUtil.notifyUser("Grafo preenchido com os dados de exemplo.");
            } else if (option == 4) {
                if (SystemUtil.exampleDataOrd(graph))// se foi preenchido corretamente
                    SystemUtil.notifyUser("Grafo preenchido com os dados de exemplo.");
            } else if (option == 5) {
                if (graph == null) {
                    SystemUtil.notifyUser("O grafo ainda nao foi criado, crie-o primeiro.");
                    continue;
                }

                int linha = 0, coluna = 0, tamanho = graph.length - 1;
                do {
                    System.out.println("Digite a linha desejada: ");
                    linha = scan.nextInt();
                    System.out.println("Digite a coluna desejada: ");
                    coluna = scan.nextInt();

                    if (coluna < 1 || coluna < 1 || linha > tamanho || coluna > tamanho)
                        SystemUtil.notifyUser(String.format("Colunas disponiveis entre 1 e %d", tamanho));

                    if (linha == coluna) {
                        SystemUtil.notifyUser("Posicao invalida");
                    }

                } while (linha > tamanho || coluna > tamanho || coluna < 1 || linha < 1 || linha == coluna);

                System.out.println("Digite o valor do vertice: ");
                int conteudo = scan.nextInt();
                insertVertex(conteudo, linha, coluna);

            } else if (option == 6) {
                System.out.println("Qual o vertice origem? ");
                int origem = scan.nextInt();

                System.out.println("Qual o vertice destino? ");
                int destino = scan.nextInt();

                System.out.println(findRoute(origem, destino));
                SystemUtil.waitUser();
            }
        } while (option != 8);

        // System.out.println(findRoute(1, 12));

        scan.close();
    }
}