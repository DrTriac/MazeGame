package be.kdg.mazeGame.view.gameScreen;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the actual game, to connect model and view
 */

import be.kdg.mazeGame.model.*;
import be.kdg.mazeGame.view.loseScreen.LosePresenter;
import be.kdg.mazeGame.view.loseScreen.LoseView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import be.kdg.mazeGame.view.winScreen.WinPresenter;
import be.kdg.mazeGame.view.winScreen.WinView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;
    private Color playerColor;
    private Timeline timer;

    public MazeGamePresenter(MazeGameView view, MazeGame model, Color playerColor) {
        this.view = view;
        this.model = model;
        this.playerColor = playerColor;

        loadTextures();

        view.setFocusTraversable(true); // ensures that the view can receive keyboard iput

        addEventHandlers();
        updateView();
        startTimer();

        Platform.runLater(() -> view.getMazeCanvas().requestFocus()); // request focus on the canvas after the window appears
    }

    private void addEventHandlers() {
        view.getMazeCanvas().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                    case UP -> model.movePlayer(-1, 0);
                    case DOWN -> model.movePlayer(1, 0);
                    case RIGHT -> model.movePlayer(0, 1);
                    case LEFT -> model.movePlayer(0, -1);
                }
                updateView();
                checkWinCondition();
        });

        view.getNewGame().setOnAction(event -> {
            goToStartScreen();
        });

        view.getHighScores().setOnAction(event -> {});
    }

    private void updateView() {
        view.drawMap(getMapData(model.getCurrentMap()), model.getPlayer().getColumn(), model.getPlayer().getRow(), playerColor);
        view.getPlayerLabel().setText(model.getPlayer().getPlayerName());
    }

    private String[][] getMapData(Map map) {
        String[][] mapData = new String[map.getHeight()][map.getWidth()];

        for (int row = 0; row < map.getHeight(); row++) {
            for (int column = 0; column < map.getWidth(); column++) {
                MapElement element = map.getTile(row, column);

                String textureName = switch (element) {
                    case Wall w -> "wall";
                    case Finish f -> "finish";
                    default -> "floor";
                };

                mapData[row][column] = textureName;
            }
        }
        return mapData;
    }

    public void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            model.decreaseTime();
            view.updateTimer(model.getTimeLeft());
            if (model.getTimeLeft() == 0) {
                timer.stop();
                Platform.runLater(() -> {
                    LoseView loseView = new LoseView();
                    Stage loseStage = new Stage();
                    Scene loseScene = new Scene(loseView);

                    Stage mainStage = (Stage) view.getScene().getWindow();

                    LosePresenter losePresenter = new LosePresenter(model, playerColor,loseView, loseStage, mainStage);

                    loseStage.initModality(Modality.APPLICATION_MODAL); // spelvenster blokkeren
                    loseStage.setScene(loseScene);
                    loseStage.setX(view.getScene().getWindow().getX() + 150);
                    loseStage.setY(view.getScene().getWindow().getY() + 150);

                    loseStage.showAndWait();
                });
            }
            if (model.getTimeLeft() == 10) {
                view.showTimeAlert();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void loadTextures() {
        TextureManager.loadImage("wall", "/be/kdg/mazeGame/stone_wall_8.png");
        TextureManager.loadImage("floor", "/be/kdg/mazeGame/floor.jpg");
        TextureManager.loadImage("finish", "/be/kdg/mazeGame/finish2.png");
    }

    private void checkWinCondition() {
        if (model.finished()) {
            timer.stop();
            model.getPlayer().setScore(model.getTimeLeft() * 1000);
            int totalScore = model.getPlayer().getScore();
            /**saveHighScore(score);*/

            WinView winView = new WinView(model.getPlayer().getScore(), model.getTimeLeft());
            Stage winStage = new Stage();
            Scene winScene = new Scene(winView);

            Stage mainStage = (Stage) view.getScene().getWindow(); // to get the stage, getStage() does not exist

            WinPresenter winPresenter = new WinPresenter(model, playerColor, winView, winStage, mainStage);

            winStage.initModality(Modality.APPLICATION_MODAL); // spelvenster blokkeren
            winStage.setScene(winScene);
            winStage.setX(view.getScene().getWindow().getX() + 150);
            winStage.setY(view.getScene().getWindow().getY() + 150);

            winStage.showAndWait();
        }

    }

    private void goToStartScreen() {
        Stage mainStage = (Stage) view.getScene().getWindow();
        StartView startView = new StartView();
        mainStage.getScene().setRoot(startView);

        new StartPresenter(startView);
    }


}
