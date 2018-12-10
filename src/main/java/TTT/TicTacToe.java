package TTT;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JPanel {
    JButton buttons[] = new JButton[9];
    public static int difficulty=1;

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
            JButton buttonClicked = (JButton) e.getSource();
            if(!GameLogic.end)
            {
                switch (difficulty){
                    case 1:{//PvP
                        char result = GameLogic.move(position/3, position%3);
                        if(result!='N'){
                            buttonClicked.setText(String.valueOf(result));
                            if(GameLogic.end)
                                JOptionPane.showConfirmDialog(null, "Player "+ result + " won!");
                        }

                    }
                    case 2:{//PvRandomAI
                        char result = GameLogic.move(position/3, position%3);
                        if(result!='N'){
                            buttonClicked.setText(String.valueOf(result));
                            if(GameLogic.end)
                                JOptionPane.showConfirmDialog(null, "Player "+ result + " won!");
                            else if(GameLogic.moves<9){
                                int[] AImove = RandomAI.randomMove();
                                if((char)AImove[0]!='N'){
                                    buttons[AImove[1]*3+AImove[2]].setText(String.valueOf((char)AImove[0]));
                                    if(GameLogic.end)
                                        JOptionPane.showConfirmDialog(null, "The Computer won!");
                                }
                            } else
                            {
                                JOptionPane.showConfirmDialog(null, "No winner! Try again");
                            }
                        }

                    }
                    case 3:{//PvSmartAI
                        char result = GameLogic.move(position/3, position%3);
                        if(result!='N'){
                            buttonClicked.setText(String.valueOf(result));
                            if(GameLogic.end)
                                JOptionPane.showConfirmDialog(null, "Player "+ result + " won!");
                            else if(GameLogic.moves<9){
                                int[] AImove = SmartAI.smartMove();
                                if((char)AImove[0]!='N'){
                                    buttons[AImove[1]*3+AImove[2]].setText(String.valueOf((char)AImove[0]));
                                    if(GameLogic.end)
                                        JOptionPane.showConfirmDialog(null, "The Computer won!");
                                }
                            } else
                            {
                                JOptionPane.showConfirmDialog(null, "No winner! Try again");
                            }
                        }


                    }
                }
            }


        }
    }

    public static void main(String[] args)
    {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMenu.setVisible(true);
    }
}
