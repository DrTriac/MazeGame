package be.kdg.mazeGame.view.startScreen;

/**
 * Author: Astrid
 * Date: 18/03/2026
 * Description: null.java class for the maze game.
 */
import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Player;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
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

            MazeGameView gameView = new MazeGameView();
            MazeGame model = new MazeGame(player);

            MazeGamePresenter presenter = new MazeGamePresenter(gameView, model, playerColor);

            stage.getScene().setRoot(gameView);
            gameView.requestFocus();
        });

    }


}
