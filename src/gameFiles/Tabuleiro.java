package gameFiles;

import _utility.scanner;

public class Tabuleiro{
    
    private EstadoEspaco[][] tabuleiro = new EstadoEspaco[3][3];
    private int turno;
    private char[][] tabuleiroVisivel = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};

    public Tabuleiro(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.tabuleiro[i][j] = EstadoEspaco.VAZIO;
            }
        }
    }

    public void printTabuleiro(){

        for(char[] linha : this.tabuleiroVisivel){
            for(char c : linha){
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public void marcarPosicao(int pos, Jogador player){
        int out = 0;
        do{
            switch(pos) {
                case 1:
                    if (this.tabuleiro[0][0] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[0][0] = player.getSimbolo();
                    this.tabuleiro[0][0] = player.getTipo();
                    out = 1;
                    break;
                case 2:
                    if (this.tabuleiro[0][1] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[0][2] = player.getSimbolo();
                    this.tabuleiro[0][1] = player.getTipo();
                    out = 1;
                    break;
                case 3:
                    if (this.tabuleiro[0][2] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[0][4] = player.getSimbolo();
                    this.tabuleiro[0][2] = player.getTipo();
                    out = 1;
                    break;
                case 4:
                    if (this.tabuleiro[1][0] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[2][0] = player.getSimbolo();
                    this.tabuleiro[1][0] = player.getTipo();
                    out = 1;
                    break;
                case 5:
                    if (this.tabuleiro[1][1] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[2][2] = player.getSimbolo();
                    this.tabuleiro[1][1] = player.getTipo();
                    out = 1;
                    break;
                case 6:
                    if (this.tabuleiro[1][2] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[2][4] = player.getSimbolo();
                    this.tabuleiro[1][2] = player.getTipo();
                    out = 1;
                    break;
                case 7:
                    if (this.tabuleiro[2][0] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[4][0] = player.getSimbolo();
                    this.tabuleiro[2][0] = player.getTipo();
                    out = 1;
                    break;
                case 8:
                    if (this.tabuleiro[2][1] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[4][2] = player.getSimbolo();
                    this.tabuleiro[2][1] = player.getTipo();
                    out = 1;
                    break;
                case 9:
                    if (this.tabuleiro[2][2] != EstadoEspaco.VAZIO) {
                        System.out.println("\nSpace already occupied!\n");
                        pos = scanner.scanRange("Type another position: ", 1, 9);
                        break;

                    }
                    this.tabuleiroVisivel[4][4] = player.getSimbolo();
                    this.tabuleiro[2][2] = player.getTipo();
                    out = 1;
                    break;
                default:

                    break;
                }
        }while(out == 0);
    }

    public static String checaJogador(EstadoEspaco marca, Jogador jogadorUm, Jogador jogadorDois){
        String nome;
        if(marca == EstadoEspaco.JOGADOR_UM){
           nome = jogadorUm.getNome();
        }
        else if(marca == EstadoEspaco.JOGADOR_DOIS){
            nome = jogadorDois.getNome();
        }
        else{
            nome = "Player checker Error!";
        }
        return nome;
    }

    public String checaVencedor(Jogador jogadorUm, Jogador jogadorDois){
        String nome = "Winner checker Error!";
        int pontos = 0;

        //Vitoria horizontal
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.tabuleiro[i][j] == EstadoEspaco.VAZIO) {
                    pontos = 0;
                    break;
                } else if (this.tabuleiro[i][j] == this.tabuleiro[i][j + 1]) {
                    pontos++;
                    if (pontos == 2) {
                        nome = checaJogador(this.tabuleiro[i][j], jogadorUm, jogadorDois);
                        return nome;
                    }
                } else {
                    pontos = 0;
                    break;
                }
            }
        }


        //Vitoria vetical
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                if (this.tabuleiro[i][j] == EstadoEspaco.VAZIO) {
                    pontos = 0;
                    break;
                } else if (this.tabuleiro[i][j] == this.tabuleiro[i + 1][j]) {
                    pontos++;
                    if (pontos == 2) {
                        nome = checaJogador(this.tabuleiro[i][0], jogadorUm, jogadorDois);
                        return nome;
                    }
                } else {
                    pontos = 0;
                    break;
                }
            }
        }

        //Vitoria horizontal principal
        for(int i = 0; i < 2; i++){
            if (this.tabuleiro[i][i] == EstadoEspaco.VAZIO) {
                pontos = 0;
                break;
            } else if (this.tabuleiro[i][i] == this.tabuleiro[i+1][i+1]) {
                pontos++;
                if (pontos == 2) {
                    nome = checaJogador(this.tabuleiro[i][i], jogadorUm, jogadorDois);
                    return nome;
                }
            } else {pontos = 0; break;}
        }

        //Diagonal secundaria
        for(int i = 2; i > 0; i--){
            if (this.tabuleiro[i][i] == EstadoEspaco.VAZIO) {
                pontos = 0;
                break;
            } else if (this.tabuleiro[i][i] == this.tabuleiro[i -1][i-1]) {
                pontos++;
                if (pontos == 2) {
                    nome = checaJogador(this.tabuleiro[i][i], jogadorUm, jogadorDois);
                    return nome;
                }
            } else {pontos = 0; break;}
        }
        return "";
    }

    public int checaEmpate(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.tabuleiro[i][j] == EstadoEspaco.VAZIO){
                    return 0;
                }
            }
        }
        return 1;
    }
}



