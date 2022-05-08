package ticTacToe;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.Parent;

public class GameBoard {
    GamePlay currentGame;
    Label info;
    GamePiece[][] buttons;
    boolean gameOver;
    
    public GameBoard(GamePlay currentGame){
        this.currentGame = currentGame;
        info = new Label(currentGame.getCurrentPlayer());
        buttons = new GamePiece[3][3]; 
        createButtons();
    }
    
    public void createButtons(){
        String buttonName;
        for(int i = 0; i < 3; i++){//rows
            for(int j = 0; j < 3; j++){//columns
                buttonName = "button" + j + " " + i;
                buttons[j][i] = new GamePiece(buttonName,j,i,currentGame);
            }
    }
}        
    public Parent getView(){
        
         //delare main layout
        BorderPane layout = new BorderPane();                

        //create buttom layout
        GridPane buttonGrid = new GridPane();
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setPadding(new Insets(10,10,10,10));
        buttonGrid.setHgap(5);
        buttonGrid.setVgap(5);
        //add buttons to buttongrid
        for(int i = 0; i < 3; i++){ //rows
            for(int j = 0; j < 3; j++){ //columns
                buttonGrid.add(buttons[j][i].getButton(), 
                        buttons[j][i].getPosition()[0], buttons[j][i].getPosition()[1]);
            }            
        }
       
        //create text layout with the labels   
        info.setFont(Font.font("Monospaced", 40));
        info.setAlignment(Pos.CENTER);
        //add button grid and label to main layout
        layout.setCenter(buttonGrid);          
        layout.setTop(info);  
        
        //event handlers for buttons
        buttons[0][0].getButton().setOnAction((event) -> {
            gameOver = buttons[0][0].buttonClick();
            if(gameOver){
                gameOver();
            } else{
                info.setText(currentGame.getCurrentPlayer());
            }            
        });
        buttons[1][0].getButton().setOnAction((event) -> {
            gameOver = buttons[1][0].buttonClick();
            if(gameOver){
                gameOver();
            }  else{
                info.setText(currentGame.getCurrentPlayer());
            }          
        });
        buttons[2][0].getButton().setOnAction((event) -> {
            gameOver = buttons[2][0].buttonClick();
            if(gameOver){
                gameOver();
            } else{
                info.setText(currentGame.getCurrentPlayer());
            }          
        });

        buttons[0][1].getButton().setOnAction((event) -> {
            gameOver = buttons[0][1].buttonClick();
            if(gameOver){
                gameOver();
            } else{
                info.setText(currentGame.getCurrentPlayer());
            }           
        });

        buttons[1][1].getButton().setOnAction((event) -> {
            gameOver = buttons[1][1].buttonClick();
            if(gameOver){
                gameOver();
            } else{
                info.setText(currentGame.getCurrentPlayer());
            }           
        });
        buttons[2][1].getButton().setOnAction((event) -> {
            gameOver = buttons[2][1].buttonClick();
            if(gameOver){
                gameOver();
            }  else{
                info.setText(currentGame.getCurrentPlayer());
            }          
        });
        buttons[0][2].getButton().setOnAction((event) -> {
            gameOver = buttons[0][2].buttonClick();
            if(gameOver){
                gameOver();
            }   else{
                info.setText(currentGame.getCurrentPlayer());
            }         
        });
        buttons[1][2].getButton().setOnAction((event) -> {
            gameOver = buttons[1][2].buttonClick();
            if(gameOver){
                gameOver();
            }    else{
                info.setText(currentGame.getCurrentPlayer());
            }        
        });
        buttons[2][2].getButton().setOnAction((event) -> {
            gameOver = buttons[2][2].buttonClick();
            if(gameOver){
                gameOver();
            }    else{
                info.setText(currentGame.getCurrentPlayer());
            }        
        });        
        
        return layout;
    }
        

        public void gameOver(){
            //disable all buttons
            for(int i = 0; i < 3; i++){ //for rows
                for(int j = 0; j < 3; j++){ //columns
                    buttons[j][i].getButton().setDisable(true);
                }
            }            
            info.setText("The end!");         
        }    
            
    
    
}
