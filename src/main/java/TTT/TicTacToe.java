package TTT;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JPanel {
    JButton buttons[] = new JButton[9];
    int difficulty=1;

    public TicTacToe()
    {
        setLayout(new GridLayout(3,3));
        initializebuttons();
    }

    public void initializebuttons()
    {
        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].addActionListener(new buttonListener());

            add(buttons[i]);
        }
    }
    public void resetButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText(" ");
        }
    }
    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int position=-1;

            for (int i = 0; i < 9; i++) {
                    if( buttons[i] == e.getSource() ) {
                        position=i;
                    }
            }
            System.out.println(position);
            JButton buttonClicked = (JButton) e.getSource();
            if(!GameLogic.end)
            {
                switch (difficulty){
                    case 1:{//PvP
                        System.out.println(position);
                        char result = GameLogic.move(position/3, position%3);
                        if(result!='N'){
                            buttonClicked.setText(String.valueOf(result));
                            if(GameLogic.end)
                                JOptionPane.showConfirmDialog(null, "Player"+result+"won!");
                        }

                    }
                    case 2:{//PvRandomAI

                    }
                    case 3:{//PvSmartAI

                    }
                }
            }


        }
    }

    public static void main(String[] args)
    {
        GameLogic.restartGame();
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}
