package be.kdg.mazeGame;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: Main class
 */

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.startScreen.StartScreenPresenter;
import be.kdg.mazeGame.view.startScreen.StartScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StartScreenView startScreen = new StartScreenView();
        Scene scene = new Scene(startScreen);

        stage.setScene(scene);
        stage.setTitle("Maze Game");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();

        new StartScreenPresenter(startScreen);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
