package ticTacToe;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class TicTacToeApplication extends Application {

    public void start(Stage window){
        
        GamePlay thisGame = new GamePlay();
        GameBoard board = new GameBoard(thisGame); 

        //BorderPane gameLayout = new BorderPane();
        //gameLayout.getChildren().add(board.getView());
        
        
        Scene view = new Scene(board.getView(),300,300);
               
        window.setScene(view);
        window.show();
    }   


          
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
