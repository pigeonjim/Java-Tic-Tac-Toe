package ticTacToe;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.Parent;

public class gameBoard {
    Game currentGame;
    Button topLeftButton, topCentreButton, topRightButton,
            middleLeftButton, middleCenterButton, middleRightButton, 
            bottomLeftButton, bottomCentreButton, bottomRightButton;
    Label info;
    
    public gameBoard(Game currentGame){
        this.currentGame = currentGame;
        //declare controls
        topLeftButton = createTacbutton();
        topCentreButton = createTacbutton();
        topRightButton = createTacbutton();
        middleLeftButton = createTacbutton();
        middleCenterButton = createTacbutton();
        middleRightButton = createTacbutton();
        bottomLeftButton = createTacbutton();
        bottomCentreButton = createTacbutton();
        bottomRightButton = createTacbutton();
        info = new Label("Turn: ");
        
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
        buttonGrid.add(topLeftButton, 0, 0);
        buttonGrid.add(topCentreButton,1,0);
        buttonGrid.add(topRightButton,2,0);
        buttonGrid.add(middleLeftButton, 0, 1);
        buttonGrid.add(middleCenterButton, 1, 1);
        buttonGrid.add(middleRightButton, 2, 1);
        buttonGrid.add(bottomLeftButton, 0, 2);
        buttonGrid.add(bottomCentreButton, 1, 2);
        buttonGrid.add(bottomRightButton, 2, 2);
        
        //create text layout with the labels   
        info.setFont(Font.font("Monospaced", 40));
        info.setAlignment(Pos.CENTER);
        //add button grid and text layoutto main layout
        layout.setCenter(buttonGrid);          
        layout.setTop(info);
               
        //event handlers for buttons
        topLeftButton.setOnAction((event) -> {            
            buttonClick(topLeftButton, 0, 0);
        });
        topCentreButton.setOnAction((event) -> {
            buttonClick(topCentreButton,1,0);            
        });
        topRightButton.setOnAction((event) -> {
            buttonClick(topRightButton,2,0);
        });
        middleLeftButton.setOnAction((event) -> {
            buttonClick(middleLeftButton,0,1);
        });
        middleCenterButton.setOnAction((event) -> {
            buttonClick(middleCenterButton,1,1);
        });
        middleRightButton.setOnAction((event) -> {
            buttonClick(middleRightButton,2,1);
        });
        bottomLeftButton.setOnAction((event) -> {
            buttonClick(bottomLeftButton,0,2);
        });       
        bottomCentreButton.setOnAction((event) -> {
            buttonClick(bottomCentreButton,1,2);
        });
        bottomRightButton.setOnAction((event) -> {
            buttonClick(bottomRightButton,2,2);
        });
        
        return layout;
    }
    
        public Button createTacbutton(){
        Button b = new Button(" ");
        b.setFont(Font.font("Monospaced", 40));
        return b;
    }
    
        public void buttonClick(Button b, int row, int col){
        //check that button hasnt already been chossen
            if(!b.getText().equals(" ")){
                return;
            }
            //input turn into button
            b.setText(currentGame.getCurrentPlayer());
            //increment player
            if(currentGame.getCurrentPlayer().equals("X")){
               currentGame.setCurrentPlayer("O");                            
            } else {
                currentGame.setCurrentPlayer("X");
            } 
            //add move to game array
            currentGame.addMove(row, col);
            //update the label
            info.setText("Turn: " + currentGame.getCurrentPlayer() );
            //update number of turns left
            currentGame.setTurnsLeft(currentGame.getTurnsLeft() - 1);
            
            //check for game over
            if(currentGame.checkForWinner() || currentGame.gameOver()){
                gameOver();
            }              
    }
        public void gameOver(){
            topLeftButton.setDisable(true);
            topCentreButton.setDisable(true);
            topRightButton.setDisable(true);
            middleLeftButton.setDisable(true);
            middleCenterButton.setDisable(true);
            middleRightButton.setDisable(true);
            bottomLeftButton.setDisable(true);
            bottomCentreButton.setDisable(true);
            bottomRightButton.setDisable(true);
            info.setText("The end!");            
        }               
    
}
