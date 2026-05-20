package be.kdg.mazeGame;

import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author: Astrid & Thomas
 * Description: Main class
 */

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StartView startView = new StartView();
        Scene scene = new Scene(startView);

        stage.setScene(scene);
        stage.setTitle("Maze Game");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();

        new StartPresenter(startView, stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
