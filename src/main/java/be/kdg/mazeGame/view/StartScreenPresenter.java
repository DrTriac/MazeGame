package be.kdg.mazeGame.view;

/**
 * Author: Astrid
 * Date: 18/03/2026
 * Description: null.java class for the maze game.
 */
import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Player;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartScreenPresenter {
    private StartScreenView view;
    private Stage stage;

    public StartScreenPresenter(StartScreenView view, Stage stage) {
        this.view = view;
        this.stage = stage;

        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getStartButton().setOnAction(event -> {
            String playerName = view.getNameField().getText();
            Color playerColor = view.getColorPicker().getValue();

            Player player = new Player();
            player.setPlayerName(playerName);
            player.setPlayerColor(playerColor);

            MazeGameView gameView = new MazeGameView(player);
            MazeGame model = new MazeGame(player);

            MazeGamePresenter presenter = new MazeGamePresenter(gameView, model);

            stage.getScene().setRoot(gameView);
            gameView.requestFocus();
        });

    }


}
