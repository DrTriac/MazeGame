package be.kdg.mazeGame;

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

        Scene scene = new Scene(view,800,600);

        stage.setScene(scene);
        stage.setTitle("Mazegame");
        stage.show();
    }
}
