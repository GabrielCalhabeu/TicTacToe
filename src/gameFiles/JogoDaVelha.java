package gameFiles;
import _utility.scanner;
import java.io.IOException;

public class JogoDaVelha {

    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 0;
        do {
            Tabuleiro tabuleiro = new Tabuleiro();
            Interface.clearConsole();
            Interface.menuPrincipal();
            opcao = scanner.scanNum("\nType an option: ");
                switch (opcao) {
                    case 1:
                        Jogador jogador_1 = new Jogador(scanner.scanStr("Type the name of the first player: "),
                                EstadoEspaco.JOGADOR_UM);
                        Jogador jogador_2 = new Jogador(scanner.scanStr("Type the name of the second player: "),
                                EstadoEspaco.JOGADOR_DOIS);
                        JogoDaVelha.gameLoop(tabuleiro, jogador_1, jogador_2);
                        break;
                    case 2:
                        scanner.scanStr("\n\nExiting game\nPress enter...");
                        break;
                    default:
                        scanner.scanStr("Type Something valid...\n");
                        Interface.clearConsole();
                }
            }
        while(opcao != 2);
    }

    public static void gameLoop(Tabuleiro tabuleiro, Jogador jogadorUm, Jogador jogadorDois) throws IOException, InterruptedException {
        do{
            int pos, tie;
            String winner = "";
            Interface.clearConsole();
            tabuleiro.printTabuleiro();

            //TURNO DO PRIMEIRO JOGADOR---
            System.out.println("\n" + jogadorUm.getNome() + "'s Turn\n");
            pos = scanner.scanRange("Type the position to play 1-9: ", 1, 9);
            tabuleiro.marcarPosicao(pos, jogadorUm);

            //Checando empates e vitorias

             winner = tabuleiro.checaVencedor(jogadorUm, jogadorDois);
            if(!winner.equals("")){
                System.out.println("\n\n\t" + winner + " Won!!\n");
                tabuleiro.printTabuleiro();
                scanner.scanStr("\nPress enter to continue...");
                break;
            }

            tie = tabuleiro.checaEmpate();
            if(tie == 1){
                System.out.println("\n\n\tThe game has tied!\n");
                tabuleiro.printTabuleiro();
                scanner.scanStr("\nPress enter to continue...");
                return;
            }


            Interface.clearConsole();

            //TURNO DO SEGUNDO JOGADOR
            tabuleiro.printTabuleiro();

            System.out.println("\n" + jogadorDois.getNome() + "'s Turn\n");
            pos = scanner.scanRange("Type the position to play 1-9: ", 1, 9);
            tabuleiro.marcarPosicao(pos, jogadorDois);

            winner = tabuleiro.checaVencedor(jogadorUm, jogadorDois);
            if(!winner.equals("")){
                System.out.println("\n\n\t" + winner + " Won!!\n");
                tabuleiro.printTabuleiro();
                scanner.scanStr("\nPress enter to continue...");
                break;
            }

            Interface.clearConsole();

        }while(true);


    }
}
