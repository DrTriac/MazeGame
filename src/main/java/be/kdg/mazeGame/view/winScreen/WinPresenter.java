package be.kdg.mazeGame.view.winScreen;

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen when you win, to connect model and view
 */

public class WinPresenter {

    private MazeGame model;
    private Color playerColor;
    private WinView view;
    private Stage winStage;
    private Stage mainStage;
    private int score;

    public WinPresenter(MazeGame model, Color playerColor, WinView view, Stage winStage, Stage  mainStage) {
        this.model = model;
        this.playerColor = playerColor;
        this.view = view;
        this.winStage = winStage;
        this.mainStage = mainStage;
        this.score = model.getPlayer().getScore();
        this.addEventHandlers();
        this.addWindowEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getNextLevelButton().setOnAction(event -> {
            nextLevel();
        });

        view.getMenuButton().setOnAction(event -> {
            goToStartScreen();
        });

        view.getExitButton().setOnAction(event -> {
            warningAndExit();
        });
    }

    private void updateView() {}

    private void nextLevel() {
        try {
            model.writeScore(model.getPlayer().getPlayerName(),model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("failed to write players score" + e.getMessage());
        }

        winStage.close();
        model.increaseNumberOfPlays();
        MazeGameView mazeGameView = new MazeGameView();
        MazeGame newModel = new MazeGame(model.getPlayer().getPlayerName());
        new MazeGamePresenter(mazeGameView, newModel, playerColor);
        newModel.getPlayer().setScore(score);

        mainStage.getScene().setRoot(mazeGameView);
        mainStage.sizeToScene();
    }

    private void goToStartScreen() {

        try {
            model.writeScore(model.getPlayer().getPlayerName(),model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("failed to write players score" + e.getMessage());
        }

        winStage.close();

        StartView startView = new StartView();
        mainStage.getScene().setRoot(startView);
        new StartPresenter(startView);
    }

    private void warningAndExit() {
        try {
            model.writeScore(model.getPlayer().getPlayerName(),model.getPlayer().getScore());
        } catch (IOException e) {
            System.err.println("failed to write players score" + e.getMessage());
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
        winStage.setOnCloseRequest(event -> goToStartScreen());
    }
}
