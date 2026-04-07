package be.kdg.mazeGame;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: Main class
 */

import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StartView startScreen = new StartView();
        Scene scene = new Scene(startScreen);

        stage.setScene(scene);
        stage.setTitle("Maze Game");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();

        new StartPresenter(startScreen);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
