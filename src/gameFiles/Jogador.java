package gameFiles;

public class Jogador {


    private String nome;
    private EstadoEspaco tipo;
    private char simbolo;

    public Jogador(String nome, EstadoEspaco tipo){
        if(nome == null || nome.equals("")){
            this.nome = "Player";
        }
        else{this.nome = nome;}

        if(tipo == EstadoEspaco.JOGADOR_UM){
            this.tipo = EstadoEspaco.JOGADOR_UM;
            this.simbolo = 'X';
        } else if(tipo == EstadoEspaco.JOGADOR_DOIS){
            this.tipo = EstadoEspaco.JOGADOR_DOIS;
            this.simbolo = 'O';
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(EstadoEspaco tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public EstadoEspaco getTipo() {
        return tipo;
    }

    public char getSimbolo(){return simbolo;}

}

