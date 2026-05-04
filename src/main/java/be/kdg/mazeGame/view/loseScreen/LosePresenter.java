package be.kdg.mazeGame.view.loseScreen;

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen when you lose, to connect model and view
 */

public class LosePresenter {
    private MazeGame model;
    private Color playerColor;
    private LoseView view;
    private Stage loseStage;
    private Stage mainStage;

    public LosePresenter(MazeGame model, Color playerColor, LoseView view, Stage loseStage, Stage mainStage) {
        this.model = model;
        this.playerColor = playerColor;
        this.view = view;
        this.loseStage = loseStage;
        this.mainStage = mainStage;
        this.addEventHandlers();
        this.addWindowEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getPlayAgainButton().setOnAction(event -> {
            playAgain();
        });

        view.getMenuButton().setOnAction(event -> {
            goToStartScreen();
        });

        view.getExitButton().setOnAction(event -> {
            warningAndExit();
        });
    }

    private void updateView() {
    }

    private void playAgain() {
        loseStage.close();

        MazeGameView mazeGameView = new MazeGameView();
        MazeGame newModel = new MazeGame(model.getPlayer().getPlayerName());
        new MazeGamePresenter(mazeGameView, newModel, playerColor);

        mainStage.getScene().setRoot(mazeGameView);
        mainStage.sizeToScene();
    }

    private void goToStartScreen() {
        loseStage.close();

        StartView startView = new StartView();
        mainStage.getScene().setRoot(startView);

        new StartPresenter(startView);
    }

    private void warningAndExit() {
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
            alert.close();
        } else {
            System.exit(0);
        }
    }

    public void addWindowEventHandlers() {
        loseStage.setOnCloseRequest(event -> goToStartScreen());
    }
}
