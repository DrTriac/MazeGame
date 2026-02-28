package be.kdg.mazeGame;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: Main class
 */

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.MazeGamePresenter;
import be.kdg.mazeGame.view.MazeGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        MazeGameView view = new MazeGameView();

        MazeGame model = new MazeGame();

        MazeGamePresenter presenter = new MazeGamePresenter(view, model);

        Scene scene = new Scene(view);

        stage.setScene(scene);
        stage.setTitle("Maze Game");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
