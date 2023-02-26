package Palloncini;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PallonciniFrame extends JFrame {
    JLabel redBalloon,bombBalloon,hotAirBalloon,punteggioLabel;
    int punteggio=0;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 700;

    private float difficulty = 3;
    private boolean c;
    public void moveBalloons()
    {
        int delay = 60;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                c=true;
                moveSingleBalloon(redBalloon);
                moveSingleBalloon(bombBalloon);
                moveSingleBalloon(hotAirBalloon);
            }

        };
        new Timer(delay, taskPerformer).start();
    }

    private void moveSingleBalloon(JLabel balloon) {
        balloon.setLocation((balloon.getLocation().x), (int) (balloon.getLocation().y-difficulty));
        if(balloon.getLocation().y<-50){
            balloon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), FRAME_HEIGHT);
        }

        balloon.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                balloon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), FRAME_HEIGHT);
                if(c){
                    difficulty+=0.2;
                    System.out.println(difficulty);
                    c=false;
                    System.out.println(balloon.getName());
                    switch (balloon.getName()){
                        case "redBalloon":
                            punteggio++;
                            break;
                        case "hotAirBalloon":
                            punteggio+=3;
                            break;
                        case "bombBalloon":
                            punteggio-=5;
                            break;
                    }
                    punteggioLabel.setText("Punteggio: "+punteggio);
                }
            }
        });
    }


    public PallonciniFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel mainPanel = new JPanel(null);

        mainPanel.setBackground(Color.green);

        redBalloon = new JLabel(new ImageIcon("redBalloon.png"));
        redBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        redBalloon.setName("redBalloon");

        bombBalloon = new JLabel(new ImageIcon("bombBalloon.png"));
        bombBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,150,150);
        bombBalloon.setName("bombBalloon");

        hotAirBalloon = new JLabel(new ImageIcon("hotAirBalloon.png"));
        hotAirBalloon.setName("hotAirBalloon");
        hotAirBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,100,100);




        punteggioLabel = new JLabel("Punteggio: "+punteggio);
        punteggioLabel.setBounds(0,0,150,15);

        mainPanel.add(redBalloon);
        mainPanel.add(bombBalloon);
        mainPanel.add(hotAirBalloon);

        mainPanel.add(punteggioLabel);

        this.add(mainPanel);
        this.setVisible(true);

        moveBalloons();
    }
}
