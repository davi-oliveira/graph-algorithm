class Graph {
    static int[][] graph = new int[10][10];
    static int soma = 0;

    /*
     * >> CORES
     */
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";

    public static void markImpossible(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }
    }

    public static void printGraph(int[][] graph) {
        for (int l = 0; l < graph.length; l++) {
            System.out.print((l != 0 ? textWithColor(l, ANSI_YELLOW) : " ") + "\t");
            for (int c = 1; c < graph.length; c++) {
                if (l == c)
                    System.out.print(textWithColor("XX", ANSI_RED));
                else
                    System.out.print(l == 0 ? textWithColor(c, ANSI_YELLOW) : graph[l][c]);

                System.out.print("\t");
            }
            System.out.print("\n");

        }
    }

    public static int menorRota(int inicio, int fim) {
        System.out.println("--> " + inicio);

        if (graph[inicio][fim] != 0){
            return graph[inicio][fim];
        }

        if (inicio <= 10){
            if (graph[inicio][inicio + 1] != 0)
                soma += graph[inicio][inicio + 1] + menorRota(inicio + 1, fim);
            else {
                inicio++;
                soma += graph[inicio][inicio + 1] + menorRota(inicio + 1, fim);
            }
        }
        return soma;

    }

    public static String textWithColor(String text, String color) {
        return color + text + ANSI_RESET;
    }

    public static String textWithColor(Integer text, String color) {
        return color + Integer.toString(text) + ANSI_RESET;
    }

    public static void main(String[] args) {
        markImpossible(graph);

        // 1 > 2
        graph[1][2] = 17;
        graph[2][1] = 17;

        // 1 > 3
        graph[1][3] = 25;
        graph[3][1] = 25;

        // 1 > 5
        graph[1][5] = 21;
        graph[5][1] = 21;

        // 2 > 4
        graph[2][4] = 10;
        graph[4][2] = 10;

        // 2 > 6
        graph[2][6] = 15;
        graph[6][2] = 15;

        // 3 > 7
        graph[3][7] = 20;
        graph[7][3] = 20;

        // 4 > 6
        graph[4][6] = 9;
        graph[6][4] = 9;

        // 4 > 8
        graph[4][8] = 23;
        graph[8][4] = 23;

        // 5 > 6
        graph[5][6] = 12;
        graph[6][5] = 12;

        // 5 > 7
        graph[5][7] = 19;
        graph[7][5] = 19;

        // 6 > 8
        graph[6][8] = 8;
        graph[8][6] = 8;

        // 6 > 9
        graph[6][9] = 7;
        graph[9][6] = 7;

        // 7 > 9
        graph[7][9] = 17;
        graph[9][7] = 17;

        // 8 > 9
        graph[8][9] = 10;
        graph[9][8] = 10;

        printGraph(graph);

        System.out.println(menorRota(1, 7));

    }
}