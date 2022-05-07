
package ticTacToe;
import java.util.Arrays;

public class GamePlay {
    private int turnsLeft;
    private String[][] moves;
    private String currentPlayer;
    
    public GamePlay(){
        this.turnsLeft = 9;
        moves = new String[3][3];
        currentPlayer = "Turn: X";
        
        //inialise array to remove Nulls
        for(String[] ary: moves){
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
       this.moves[row][column] = getButtonPlayer();
        //increment player
        if(currentPlayer.equals("Turn: X")){
            currentPlayer = "Turn: O";                            
        } else {
            currentPlayer = "Turn: X";
        }
        //update number of turns left
        turnsLeft--;        
    }
    
    public boolean checkFor3inaRow(String p){  
        //returns true if there is a winning line
        for(int i = 0; i < 3; i++){
            //check for vertical 3 in a row
            if(this.moves[i][0].equals(p) && this.moves[i][1].equals(p) && this.moves[i][2].equals(p) ){
                return true;
            }
            //check for horizontal 3 in a row
            if(this.moves[0][i].equals(p) && this.moves[1][i].equals(p) && this.moves[2][i].equals(p) ){
                return true;
            }
        }
        //check for diagonal 3 in a row
        if(this.moves[0][0].equals(p) && this.moves[1][1].equals(p) && this.moves[2][2].equals(p) ){
                return true;
            }
        if(this.moves[2][0].equals(p) && this.moves[1][1].equals(p) && this.moves[0][2].equals(p) ){
                return true;
            }                
        return false;
    }
    
    public boolean checkForWinner(){
        if(checkFor3inaRow("X") || checkFor3inaRow("O")){
            return true;//there is a winner
        }
        return false; //no winner yet
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    public String getButtonPlayer(){
        //Returns X or O to populate button text
        String[] bits = currentPlayer.split(" ");
        return bits[1];
    }
       
}
