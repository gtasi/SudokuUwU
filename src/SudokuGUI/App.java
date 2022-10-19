package SudokuGUI;
import javax.swing.JButton;

import java.awt.*;
import javax.swing.*;

public class App extends JFrame{
    private static final long serialVersionUID = 1L;  
    
        Gui board=new Gui();
        JButton btnNewGame=new JButton("New Game");
    
    public App(){
        Container cp=getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(board,BorderLayout.CENTER);

        board.newGame();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
}
}
