package gameFiles;
import java.io.IOException;
public class Interface {

    public static void menuPrincipal(){
        System.out.println("\t========== Welcome to Tic-Tac-Toe ===========");
        System.out.println("\n\n1 - Play");
        System.out.println("\n2 - Quit");
    }

    public static void clearConsole(String... arg) throws IOException, InterruptedException {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
