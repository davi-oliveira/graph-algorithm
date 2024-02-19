import java.util.Scanner;

public class SystemUtil {

    static final String ANSI_RESET = "\u001B[0m";

    public static void waitUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPressione alguma tecla para continuar...");
        input.nextLine();
    }

    public static String textWithColor(String text, String color) {
        return color + text + ANSI_RESET;
    }

    public static String textWithColor(Integer text, String color) {
        return color + Integer.toString(text) + ANSI_RESET;
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void fillWithNought(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }
    }

    public static void notifyUser(String message){
        clearTerminal();
        System.out.println(message);
        SystemUtil.waitUser();
    }

    public static void exampleData(int[][] graph) {
        if(graph == null){
            notifyUser("O grafo ainda nao foi criado, crie-o primeiro.");
            return;
        }

        if(graph.length != 12+1){
            notifyUser("O grafo de exemplo eh de ordem 13 e o criado atualmente nao.");
            return;
        }

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

        // 7 > 11
        graph[7][11] = 12;
        graph[11][7] = 12;

        // 7 > 12
        graph[7][12] = 22;
        graph[12][7] = 22;

        // 8 > 9
        graph[8][9] = 10;
        graph[9][8] = 10;

        // 8 > 10
        graph[8][10] = 13;
        graph[10][8] = 13;

        // 9 > 10
        graph[9][10] = 12;
        graph[10][9] = 12;

        // 9 > 11
        graph[9][11] = 15;
        graph[11][9] = 15;

        // 10 > 11
        graph[10][11] = 14;
        graph[11][10] = 14;

        // 10 > 12
        graph[10][12] = 21;
        graph[12][10] = 21;

        // 11 > 12
        graph[11][12] = 10;
        graph[12][11] = 10;
    }
}
