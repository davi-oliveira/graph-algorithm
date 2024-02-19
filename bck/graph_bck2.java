import java.util.Scanner;

class Graph {
    static int[][] graph = new int[10][10];
    static int soma = 0;

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

    public static int menorRota(int inicio, int fim) {
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

            soma += graph[inicio][proximo] + menorRota(proximo, fim);
        }
        return soma;

    }

    public static void showMenu() {
        SystemUtil.clearTerminal();
        System.out.println("Menu");
        System.out.println("1 - Mostrar grafo atual");
        System.out.println("2 - Preencher com os dados da aula");
        System.out.println("3 - Inserir vertice");
        System.out.println("6 - Sair do programa");
        System.out.print("\nDigite a opcao desejada: ");
    }

    public static void main(String[] args) {
        SystemUtil.fillWithNought(graph);
        SystemUtil.exampleData(graph);
        
        int option = -1;
        Scanner scan = new Scanner(System.in);
        do {
            showMenu();
            option = scan.nextInt();

            if(option == 1){
                SystemUtil.clearTerminal();
                printGraph();
            }
            else if(option == 2){
                SystemUtil.exampleData(graph);
            }
        } while (option != 6);

        System.out.println(menorRota(1, 7));

        scan.close();

    }

}