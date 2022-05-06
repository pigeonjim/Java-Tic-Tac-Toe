package ticTacToe;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;


public class TicTacToeApplication extends Application {

    public void start(Stage window){
        
        Game thisGame = new Game();
        gameBoard board = new gameBoard(thisGame); 

        BorderPane gameLayout = new BorderPane();
        gameLayout.getChildren().add(board.getView());
        
        
        Scene view = new Scene(gameLayout,300,300);
               
        window.setScene(view);
        window.show();
    }
    


          
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
