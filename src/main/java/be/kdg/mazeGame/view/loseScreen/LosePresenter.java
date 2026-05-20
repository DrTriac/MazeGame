package be.kdg.mazeGame.view.loseScreen;

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.gameScreen.SoundManager;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen when you lose, to connect model and view
 */

public class LosePresenter {
    private final MazeGame model;
    private final Color playerColor;
    private final LoseView view;
    private final Stage loseStage;
    private final Stage mainStage;
    private final int score;

    public LosePresenter(MazeGame model, Color playerColor, LoseView view, Stage loseStage, Stage mainStage) {
        this.model = model;
        this.playerColor = playerColor;
        this.view = view;
        this.loseStage = loseStage;
        this.mainStage = mainStage;
        this.score = model.getPlayer().getScore();
        addEventHandlers();
        addWindowEventHandlers();
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

    private void playAgain() {
        try {
            model.writeScore(model.getPlayer().getPlayerName(), model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("Failed to write players score" + e.getMessage());
        }

        loseStage.close();

        MazeGameView mazeGameView = new MazeGameView();
        MazeGame newModel = new MazeGame(model.getPlayer().getPlayerName(), model.getNumberOfPlays());
        MazeGamePresenter mazeGamePresenter = new MazeGamePresenter(mazeGameView, mainStage, newModel, playerColor);
        mazeGamePresenter.startTimer();
        SoundManager.playTune("backgroundTrack.mp3");
        newModel.getPlayer().setScore(score);

        mainStage.getScene().setRoot(mazeGameView);
        mainStage.sizeToScene();
    }

    private void goToStartScreen() {
        try {
            model.writeScore(model.getPlayer().getPlayerName(), model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("Failed to write players score" + e.getMessage());
        }

        loseStage.close();

        StartView startView = new StartView();
        mainStage.getScene().setRoot(startView);
        new StartPresenter(startView, mainStage);
    }

    private void warningAndExit() {
        try {
            model.writeScore(model.getPlayer().getPlayerName(), model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("Failed to write players score" + e.getMessage());
        }

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
