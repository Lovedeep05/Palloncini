package Palloncini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PallonciniFrame extends JFrame {


    JLabel palloncino1,palloncino2;

    public void moveBalloons()
    {

        int delay = 30;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                palloncino1.setLocation((palloncino1.getLocation().x), palloncino1.getLocation().y-5);
                if(palloncino1.getLocation().y<0){
                    palloncino1.setLocation(250, 500);
                }
                palloncino2.setLocation((palloncino2.getLocation().x), palloncino2.getLocation().y-5);
                if(palloncino2.getLocation().y<0){
                    palloncino2.setLocation(400, 500);
                }
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    public PallonciniFrame() {
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel mainPanel = new JPanel(null);

        mainPanel.setBackground(Color.green);


        ImageIcon redBalloon = new ImageIcon("redBalloon.png");
        ImageIcon blackBalloon = new ImageIcon("blackBalloon.png");

        palloncino1 = new JLabel(redBalloon);
        palloncino1.setBounds(100,420,30,72);

        palloncino2 = new JLabel(blackBalloon);
        palloncino2.setBounds(200,350,88,70);

        moveBalloons();



        mainPanel.add(palloncino1);
        mainPanel.add(palloncino2);

        this.add(mainPanel);
        this.setVisible(true);
    }
}
