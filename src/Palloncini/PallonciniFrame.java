package Palloncini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PallonciniFrame extends JFrame {


    public void MoveForPlayer(JLabel balloon)
    {

        int delay = 60;
        ActionListener taskPerformer = new ActionListener() {
            int count=0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if(count==100) {
                    ((Timer)evt.getSource()).stop();
                }
                balloon.setLocation((balloon.getLocation().x), balloon.getLocation().y-5);
                if(balloon.getLocation().y<0){
                    balloon.setLocation(250, 500);
                }
                count++;
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    public PallonciniFrame() {
        this.setSize(500,500);
        this.setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(null);

        mainPanel.setBackground(Color.green);


        ImageIcon redBalloon = new ImageIcon("redBalloon.png");
        JLabel palloncino1 = new JLabel(redBalloon);
        palloncino1.setBounds(100,420,30,72);


        MoveForPlayer(palloncino1);
        //MoveForPlayer(palloncino2);



        mainPanel.add(palloncino1);

        this.add(mainPanel);
        this.setVisible(true);
    }
}
