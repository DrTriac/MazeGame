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

public class StartPresenter {
    private StartView view;

    public StartPresenter(StartView view) {
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getStartButton().setOnAction(event -> {
            String playerName = view.getNameField().getText();
            Color playerColor = view.getColorPicker().getValue();

            Player player = new Player();
            player.setPlayerName(playerName);

            MazeGameView gameView = new MazeGameView();
            MazeGame model = new MazeGame(playerName);

            MazeGamePresenter presenter = new MazeGamePresenter(gameView, model, playerColor);

            view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });

    }


}
