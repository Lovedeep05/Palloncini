package gameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PallonciniFrame extends JFrame {


    ArrayList<JLabel> lives = new ArrayList<JLabel>(3);

    JLabel sfondo,bombBalloon,hotAirBalloon,punteggioLabel,redBalloon,blueBalloon,greenBalloon,orangeBalloon,purpleBalloon,yellowBalloon, cuore;
    JPanel mainPanel = new JPanel(null);
    int vite=3;
    int punteggio=0;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 700;

    private float difficulty = 3;
    private boolean c;
    BufferedWriter writer = new BufferedWriter(new FileWriter("punteggio.txt"));


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
                moveSingleBalloon(yellowBalloon);
                moveSingleBalloon(blueBalloon);
                moveSingleBalloon(purpleBalloon);
                moveSingleBalloon(orangeBalloon);
                moveSingleBalloon(greenBalloon);
            }

        };
        new Timer(delay, taskPerformer).start();
    }

    private void moveSingleBalloon(JLabel balloon) {
        for(int i=0;i<(int)difficulty;i++){
            balloon.setLocation((balloon.getLocation().x), (balloon.getLocation().y-1));
        }
        if(balloon.getLocation().y<-50){
            balloon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), FRAME_HEIGHT);
        }

        balloon.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                balloon.setLocation((int)(Math.random() * ((FRAME_WIDTH-10) + 1)), FRAME_HEIGHT);
                if(c){
                    difficulty+=0.1;
                    System.out.println(difficulty);
                    c=false;
                    System.out.println(balloon.getName());
                    switch (balloon.getName()){
                        case "regularBalloon":
                            punteggio++;

                            break;
                        case "hotAirBalloon":
                            punteggio+=3;

                            break;
                        case "bombBalloon":
                            vite--;
                            punteggio-=5;
                            lives.get(lives.size()-1).setVisible(false);
                            lives.remove(lives.size()-1);
                            if(lives.size()==0) {
                                Main.gameFinished=true;
                                try {
                                    writer.close();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                System.exit(0);
                            }
                            //TODO palloncino che rigenera i cuori
                            break;

                    }

                    try {
                        writer.write(punteggio);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    punteggioLabel.setText("Punteggio: "+punteggio);
                }
            }
        });
    }

    public PallonciniFrame() throws IOException {



        setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        sfondo = new JLabel(new ImageIcon("Sfonod.png"));


        //TODO add a arraylist of hearths to increase how many you can have

        //Palloncino redBoi = new Palloncino("redBalloon.png",30,72,"regularBalloon");

        redBalloon = new JLabel(new ImageIcon("redBalloon.png"));
        redBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        redBalloon.setName("regularBalloon");

        blueBalloon = new JLabel(new ImageIcon("blueBalloon.png"));
        blueBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        blueBalloon.setName("regularBalloon");

        greenBalloon = new JLabel(new ImageIcon("greenBalloon.png"));
        greenBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        greenBalloon.setName("regularBalloon");

        orangeBalloon = new JLabel(new ImageIcon("orangeBalloon.png"));
        orangeBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        orangeBalloon.setName("regularBalloon");

        yellowBalloon = new JLabel(new ImageIcon("yellowBalloon.png"));
        yellowBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        yellowBalloon.setName("regularBalloon");

        purpleBalloon = new JLabel(new ImageIcon("purpleBalloon.png"));
        purpleBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,30,72);
        purpleBalloon.setName("regularBalloon");

        bombBalloon = new JLabel(new ImageIcon("bombBalloon.png"));
        bombBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,150,150);
        bombBalloon.setName("bombBalloon");

        hotAirBalloon = new JLabel(new ImageIcon("hotAirBalloon.png"));
        hotAirBalloon.setName("hotAirBalloon");
        hotAirBalloon.setBounds((int)(Math.random() * ((FRAME_WIDTH) + 1)),FRAME_HEIGHT,100,100);


        punteggioLabel = new JLabel("Punteggio: "+punteggio);
        punteggioLabel.setBounds(0,0,150,15);

        sfondo.setSize(498, 698);


        sfondo.add(redBalloon);
        sfondo.add(bombBalloon);
        sfondo.add(hotAirBalloon);
        sfondo.add(greenBalloon);
        sfondo.add(orangeBalloon);
        sfondo.add(purpleBalloon);
        sfondo.add(yellowBalloon);
        sfondo.add(blueBalloon);
        sfondo.add(punteggioLabel);

        for(int i = 0; i<vite;i++) {
            lives.add(new JLabel(new ImageIcon("pngegg.png")));
            lives.get(i).setBounds(FRAME_WIDTH-40-(i*20),5, 30,26);
            sfondo.add(lives.get(i));
        }

        mainPanel.add(sfondo);

        this.add(mainPanel);
        this.setVisible(true);

        moveBalloons();
    }
}
