
package ticTacToe;
import java.util.Arrays;

public class Game {
    private int turnsLeft;
    private String[][] move;
    private String currentPlayer;
    
    public Game(){
        this.turnsLeft = 9;
        move = new String[3][3];
        currentPlayer = "X";
        
        //inialise array to remove Nulls
        for(String[] ary: move){
          Arrays.fill(ary, " ");  
        }       
    }
    
    public boolean gameOver(){       
        if(this.turnsLeft > 0){
            return false;
        }
        
        return true;        
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    public void addMove(int row, int column) {
       this.move[row][column] = this.currentPlayer;
    }
    
    public boolean checkFor3inaRow(String p){        
        for(int i = 0; i < 3; i++){
            //check for vertical 3 in a row
            if(this.move[i][0].equals(p) && this.move[i][1].equals(p) && this.move[i][2].equals(p) ){
                return true;
            }
            //check for horizontal 3 in a row
            if(this.move[0][i].equals(p) && this.move[1][i].equals(p) && this.move[2][i].equals(p) ){
                return true;
            }
        }
        //check for diagonal 3 in a row
        if(this.move[0][0].equals(p) && this.move[1][1].equals(p) && this.move[2][2].equals(p) ){
                return true;
            }
        if(this.move[2][0].equals(p) && this.move[1][1].equals(p) && this.move[0][2].equals(p) ){
                return true;
            }                
        return false;
    }
    
    public boolean checkForWinner(){
        if(checkFor3inaRow("X") || checkFor3inaRow("O")){
            return true;
        }
        return false;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
       
}
