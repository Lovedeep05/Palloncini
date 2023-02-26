package Palloncini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PallonciniFrame extends JFrame {


    JLabel redBallon,blackBallon;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 700;

    public void moveBalloons()
    {
        int difficulty = 0;
        int delay = 60 - difficulty;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                redBallon.setLocation((redBallon.getLocation().x), redBallon.getLocation().y-5);
                if(redBallon.getLocation().y<0){
                    redBallon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), 500);
                }

                MouseListener MouseAdapter;
                redBallon.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        redBallon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), 500);
                        difficulty++;
                    }
                });

                blackBallon.setLocation((blackBallon.getLocation().x), blackBallon.getLocation().y-5);
                if(blackBallon.getLocation().y<0){
                    blackBallon.setLocation((int)(Math.random() * ((FRAME_WIDTH) + 1)), 500);
                }
            }
        };
        new Timer(delay, taskPerformer).start();
    }



    public PallonciniFrame() {

        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel mainPanel = new JPanel(null);

        mainPanel.setBackground(Color.green);


        ImageIcon redBalloon = new ImageIcon("redBalloon.png");
        ImageIcon blackBalloon = new ImageIcon("blackBalloon.png");

        redBallon = new JLabel(redBalloon);
        redBallon.setBounds(100,FRAME_HEIGHT,30,72);

        blackBallon = new JLabel(blackBalloon);
        blackBallon.setBounds(200,FRAME_HEIGHT,88,70);

        moveBalloons();


        mainPanel.add(redBallon);
        mainPanel.add(blackBallon);

        this.add(mainPanel);
        this.setVisible(true);
    }
}
