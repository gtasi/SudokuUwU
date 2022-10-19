package SudokuGUI;

import java.util.Random;

import javax.swing.ImageIcon;

public class Puzzle {

    int [][] numbers=new int[Gui.GRID_SIZE][Gui.GRID_SIZE];
    boolean [][] isGiven=new boolean[Gui.GRID_SIZE][Gui.GRID_SIZE];
    
    
    public Puzzle(){
        super();
    }

    public void newPuzzle(int cellsToGuess){
//Generate Random Numbers For Cells\
//TODO:Rule for Generating
        int generatedNumber;


        for(int i=0;i<Gui.GRID_SIZE;i++){
            for(int j=0;j<Gui.GRID_SIZE;j++){
                generatedNumber= generateRandomNum();
                for(int rows=0;rows<j;rows++){
                    int y_numbers[]= new int[Gui.GRID_SIZE];
                    for(int k=0;k<=rows;k++){
                        y_numbers[k]=numbers[k][j];
                    }
                    if(y_numbers[rows]==generatedNumber){
                        generatedNumber=generateRandomNum();
                        rows=0;
                    }
                }
                for(int col=0;col<i;col++){
                    int x_numbers[]=numbers[col];
                    for(int k=0;k<=col;k++){
                        x_numbers[k]=numbers[k][j];
                    }
                    if(x_numbers[col]==generatedNumber){
                        generatedNumber=generateRandomNum();
                        col=0;
                    }
                }
                numbers[i][j]=generatedNumber;

                }
                // numbers[i][j]=generateRandomNum();
            }
//Check if number exists in row or column
//If it does, generate a new number
//If it doesn't, add it to the array


//Generate Random Boolean for Cells 
 //TODO:Rule for hiding elements(amount)      
        for(int row=0;row<Gui.GRID_SIZE;row++){
            for(int col=0;col<Gui.GRID_SIZE;col++){
                isGiven[row][col]=generateRandomIsGiven();
            }
        }

    }

    public int generateRandomNum(){
        return (int)Math.floor(Math.random()*(Cell.UPPERBOUND-Cell.LOWERBOUND+1)+Cell.LOWERBOUND);
    }

    public boolean generateRandomIsGiven(){
        Random rd=new Random();
        return rd.nextBoolean();
    }
//Rule for checking if a number is valid for the specific Cell
    public boolean numIsValid(int numberIsValid,int numbers[][]){

       for(int row=0;row<Gui.GRID_SIZE;row++){
           for(int col=0;col<Gui.GRID_SIZE;col++){
               if(numbers[row][col]==numberIsValid){
                   return false;
               }
           }
        
    }
    return true;
}
}
