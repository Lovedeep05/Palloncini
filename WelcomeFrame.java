package gameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    boolean fatto= false;

    public boolean isFatto() {
        return fatto;
    }

    private String nomeFinale;

    public String getNomeFinale() {
        return nomeFinale;
    }

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 700;
    JPanel mainPanel = new JPanel(null);
    JLabel sfondo;
    JTextField nomeGiocatore;

    private void waitInput(){
        nomeGiocatore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeFinale=nomeGiocatore.getText();
                dispose();
                System.out.println("\nqua");
                fatto=true;
            }
        });
    }
    public WelcomeFrame(){

        setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        sfondo=new JLabel(new ImageIcon("Sfonod.png"));
        sfondo.setSize(498,698);
        nomeGiocatore = new JTextField();
        nomeGiocatore.setBounds(200,300,100,30);

        sfondo.add(nomeGiocatore);
        mainPanel.add(sfondo);

        this.add(mainPanel);
        this.setVisible(true);

        waitInput();
    }
}
