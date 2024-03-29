import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WelcomeFrame extends JFrame {
    private String nome;
    public String getNome() {
        return nome;
    }
    private static int difficultyMode;

    public static int getDifficultyMode() {
        return difficultyMode;
    }

    JRadioButton difficulty1;
    JRadioButton difficulty2;
    JRadioButton difficulty3;
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 200;
    JPanel mainPanel = new JPanel(null);
    JTextField nomeGiocatore;
    BufferedWriter writer = new BufferedWriter(new FileWriter("nome.txt"));
    public WelcomeFrame() throws IOException {
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JLabel insertName = new JLabel("Insert name");
        insertName.setBounds(100,35,200,20);
        nomeGiocatore = new JTextField();
        nomeGiocatore.setBounds(100,55,200,30);

        difficulty1 = new JRadioButton("Easy");
        difficulty2 = new JRadioButton("Medium");
        difficulty3 = new JRadioButton("Hard");

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(difficulty1);
        difficultyGroup.add(difficulty2);
        difficultyGroup.add(difficulty3);

        JLabel selectDifficulty = new JLabel("Select difficulty mode");
        selectDifficulty.setBounds(100,100,200,20);

        difficulty1.setBounds(100,120,60,30);
        difficulty2.setBounds(160,120,80,30);
        difficulty3.setBounds(240,120,70,30);

        difficulty1.setSelected(true);

        //mainPanel.setBackground(Color.GRAY);
        mainPanel.add(insertName);
        mainPanel.add(nomeGiocatore);
        mainPanel.add(selectDifficulty);
        mainPanel.add(difficulty1);
        mainPanel.add(difficulty2);
        mainPanel.add(difficulty3);


        this.add(mainPanel);
        this.setVisible(true);

        //TODO difficoltà scegliere fra easy medium hard
        waitInput();
    }

    private void waitInput(){
        nomeGiocatore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer.write(nomeGiocatore.getText());
                    System.out.println(nomeGiocatore.getText());
                    writer.close();
                    new PallonciniFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(difficulty1.isSelected()){
                    difficultyMode=0;
                } else if (difficulty2.isSelected()) {
                    difficultyMode=1;
                }else {
                    difficultyMode=2;
                }
                dispose();
            }
        });
    }
}
