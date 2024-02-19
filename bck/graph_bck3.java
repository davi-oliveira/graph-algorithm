import java.util.Scanner;

class Graph {
    static int[][] graph = new int[13][13];

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

    public static void showMenu() {
        SystemUtil.clearTerminal();
        System.out.println("|_____________ Menu _____________|");
        System.out.println("1 - Inicializar grafo");
        System.out.println("2 - Mostrar grafo atual");
        System.out.println("3 - Preencher com os dados da aula (ord. 12)");
        System.out.println("4 - Inserir vertice");
        System.out.println("5 - Encontrar rota aleatoria");
        System.out.println("6 - Sair do programa");
        System.out.print("\nDigite a opcao desejada: ");
    }

    public static void main(String[] args) {
        SystemUtil.fillWithNought(graph);

        int option = -1;
        Scanner scan = new Scanner(System.in);
        do {
            showMenu();
            option = scan.nextInt();

            if (option == 2) {
                SystemUtil.clearTerminal();
                printGraph();
            } else if (option == 3) {
                SystemUtil.exampleData(graph);
            } else if (option == 4) {
                System.out.println("Qual o vertice origem? ");
                int origem = scan.nextInt();

                System.out.println("Qual o vertice destino? ");
                int destino = scan.nextInt();

                System.out.println(findRoute(origem, destino));
                SystemUtil.waitUser();
            }
        } while (option != 6);

        // System.out.println(findRoute(1, 12));

        scan.close();
    }
}