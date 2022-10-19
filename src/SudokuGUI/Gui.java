package SudokuGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class Gui extends JPanel{
    public static final int GRID_SIZE=9;
    public static final int SUBGRID_SIZE=3;
    public static final int CELL_SIZE=60;
    public static final int BOARD_WIDTH=CELL_SIZE*GRID_SIZE;
    public static final int BOARD_HEIGHT=CELL_SIZE*GRID_SIZE;

    private Cell [][] cells=new Cell[GRID_SIZE][GRID_SIZE];
    private Puzzle puzzle=new Puzzle();

    public Gui(){
       super.setLayout(new GridLayout(GRID_SIZE,SUBGRID_SIZE));

       for(int row=0;row<GRID_SIZE;row++){
           for(int col=0;col<GRID_SIZE;col++){
               cells[row][col]=new Cell(row,col);
               super.add(cells[row][col]);
           }
       }
       CellInputListener listener=new CellInputListener();
       
       for(int row=0;row<GRID_SIZE;row++){
           for(int col=0;col<GRID_SIZE;col++){
               if(cells[row][col].isEditable()){
                     cells[row][col].addActionListener(listener);
               }
           }
       }
       super.setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));

}
    public void newGame(){
        puzzle.newPuzzle(2);

        for(int row=0;row<GRID_SIZE;row++){
            for(int col=0;col<GRID_SIZE;col++){
                cells[row][col].newGame(puzzle.numbers[row][col],puzzle.isGiven[row][col]);
            }
        }
    }

    public boolean isSolved(){
        for(int row=0;row<GRID_SIZE;row++){
            for(int col=0;col<GRID_SIZE;col++){
                if(cells[row][col].status==CellStatus.TO_GUESS || cells[row][col].status==CellStatus.WRONG_GUESS){
                    return false;
                }
            }
        }
        return true;
    }

    private class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           
           Cell sourceCell = (Cell)e.getSource();
  
           int numberIn = Integer.parseInt(sourceCell.getText());

           System.out.println("You entered " + numberIn);
  
            if (numberIn == sourceCell.number) {
               sourceCell.status = CellStatus.CORRECT_GUESS;
            } else {
                sourceCell.status = CellStatus.WRONG_GUESS;
            }
            sourceCell.paint();
  
        }
     }
}
