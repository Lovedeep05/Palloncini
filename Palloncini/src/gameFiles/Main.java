package gameFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static boolean gameFinished;
    public static void main(String[] args) throws IOException {
        boolean once = false;

        while(!gameFinished){
            if(!once){
                new WelcomeFrame();
            }
            once=true;
        }

        //TODO powerup per rallentare i palloncini
        BufferedReader readerNome = new BufferedReader(new FileReader("nome.txt"));
        BufferedReader readerPunteggio = new BufferedReader(new FileReader("punteggio.txt"));
        Giocatore player = new Giocatore();
        player.setNome(readerNome.readLine());
        player.setPunteggio(Integer.parseInt(readerPunteggio.readLine()));
        System.out.println(player.toString());
    }
}
