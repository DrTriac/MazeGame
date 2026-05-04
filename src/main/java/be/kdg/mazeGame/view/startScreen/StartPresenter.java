package be.kdg.mazeGame.view.startScreen;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the start screen, to connect model and view
 */

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Player;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;

public class StartPresenter {
    private StartView view;

    public StartPresenter(StartView view) {
        this.view = view;
        addEventHandlers();
        addWindowEventHandlers();
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

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("This will end the game.");
            alert.setContentText("Are you sure you want to exit?");
            alert.setTitle("Exit");

            alert.getButtonTypes().clear();

            ButtonType no = new ButtonType("No");
            ButtonType yes = new ButtonType("Yes");
            alert.getButtonTypes().setAll(no, yes);

            alert.showAndWait();

            if (alert.getResult() == null || alert.getResult().equals(no)) {
                event.consume();
            }
        });
    }


}
