package TTT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    private JButton playButton;
    private JPanel panel1;
    private JRadioButton radioButtonPvSAI;
    private JRadioButton radioButtonPvRAI;
    private JRadioButton radioButtonPvP;

    public GameMenu() {
        add(panel1);
        setTitle("Tic Tac Toe Menu");
        radioButtonPvP.setSelected(true);
        setSize(400, 200);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.restartGame();
                JFrame window = new JFrame("Tic-Tac-Toe");
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                window.getContentPane().add(new TicTacToe());
                window.setBounds(300, 200, 300, 300);
                window.setVisible(true);
            }
        });
        radioButtonPvSAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonPvSAI.isSelected()) {
                    radioButtonPvP.setSelected(false);
                    radioButtonPvRAI.setSelected(false);
                    TicTacToe.difficulty = 3;
                }
            }
        });
        radioButtonPvRAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonPvRAI.isSelected()) {
                    radioButtonPvP.setSelected(false);
                    radioButtonPvSAI.setSelected(false);
                    TicTacToe.difficulty = 2;
                }
            }
        });
        radioButtonPvP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonPvP.isSelected()) {
                    radioButtonPvRAI.setSelected(false);
                    radioButtonPvSAI.setSelected(false);
                    TicTacToe.difficulty = 1;
                }
            }
        });
    }

}
