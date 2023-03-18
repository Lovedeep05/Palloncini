import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    //TODO powerup per rallentare i palloncini
    public static void main(String[] args) throws IOException {
        new WelcomeFrame();
    }

    public static void gameFinished() throws IOException {
        BufferedReader readerNome = new BufferedReader(new FileReader("nome.txt"));
        BufferedReader readerPunteggio = new BufferedReader(new FileReader("punteggio.txt"));
        Giocatore player = new Giocatore();

        String line = null;
        while ((line = readerNome.readLine()) != null) {
            player.setNome(line);
        }
        while ((line = readerPunteggio.readLine()) != null) {
            player.setPunteggio(Integer.parseInt(line));
        }
        readerNome.close();
        readerPunteggio.close();
        System.out.println("TOSTRING:"+player.toString());
        System.exit(0);
    }
}
