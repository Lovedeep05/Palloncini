package gameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WelcomeFrame extends JFrame {
    private String nome;

    public String getNome() {
        return nome;
    }

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 200;
    JPanel mainPanel = new JPanel(null);
    JTextField nomeGiocatore;
    BufferedWriter writer = new BufferedWriter(new FileWriter("nome.txt"));

    private void waitInput(){
        nomeGiocatore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer.write(nomeGiocatore.getText());
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    new PallonciniFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
    }
    public WelcomeFrame() throws IOException {
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JLabel insertName = new JLabel("Insert name");
        insertName.setBounds(100,55,200,20);
        nomeGiocatore = new JTextField();
        nomeGiocatore.setBounds(100,75,200,30);

        //mainPanel.setBackground(Color.GRAY);
        mainPanel.add(insertName);
        mainPanel.add(nomeGiocatore);

        this.add(mainPanel);
        this.setVisible(true);
//TODO difficoltà scegliere fra easy medium hard
        waitInput();
    }
}
