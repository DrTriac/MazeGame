package be.kdg.mazeGame.view.gameScreen;

import be.kdg.mazeGame.model.*;
import be.kdg.mazeGame.view.creditsScreen.CreditsPresenter;
import be.kdg.mazeGame.view.creditsScreen.CreditsView;
import be.kdg.mazeGame.view.loseScreen.LosePresenter;
import be.kdg.mazeGame.view.loseScreen.LoseView;
import be.kdg.mazeGame.view.settingsScreen.SettingsPresenter;
import be.kdg.mazeGame.view.settingsScreen.SettingsView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import be.kdg.mazeGame.view.winScreen.WinPresenter;
import be.kdg.mazeGame.view.winScreen.WinView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the actual game, to connect model and view
 */

public class MazeGamePresenter {
    private MazeGameView view;
    private Stage mainStage;
    private MazeGame model;
    private Color playerColor;
    private Timeline timer;
    private final static int MAX_LEVEL = 3;

    public MazeGamePresenter(MazeGameView view, Stage mainStage, MazeGame model, Color playerColor) {
        this.view = view;
        this.mainStage = mainStage;
        this.model = model;
        this.playerColor = playerColor;

        loadTextures();

        view.setFocusTraversable(true);

        addEventHandlers();
        updateView();

        Platform.runLater(() -> view.getMazeCanvas().requestFocus());
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
            timer.stop();
            goToStartScreen();
        });

        view.getHighScores().setOnAction(event -> {
        });

        view.getSettings().setOnAction(event -> {
            openSettingsScreen();
        });

        view.getCredits().setOnAction(event -> {
            openCreditsScreen();
        });
    }

    private void updateView() {
        view.drawMap(getMapData(model.getCurrentMap()), model.getPlayer().getColumn(), model.getPlayer().getRow(), playerColor);
        view.getPlayerLabel().setText(model.getPlayer().getPlayerName());
        view.getLevelLabel().setText("LEVEL " + model.getNumberOfPlays());
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
                    LoseView loseView = new LoseView(model.getPlayer().getScore());
                    Stage loseStage = new Stage();
                    Scene loseScene = new Scene(loseView);

                    new LosePresenter(model, playerColor, loseView, loseStage, mainStage);

                    loseStage.initModality(Modality.APPLICATION_MODAL);
                    loseStage.setScene(loseScene);
                    loseStage.setX(mainStage.getX() + 150);
                    loseStage.setY(mainStage.getY() + 150);

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

            if (model.getNumberOfPlays() < MAX_LEVEL) {

                WinView winView = new WinView(model.getPlayer().getScore(), model.getTimeLeft());
                Stage winStage = new Stage();
                Scene winScene = new Scene(winView);

                new WinPresenter(model, playerColor, winView, winStage, mainStage);

                winStage.initModality(Modality.APPLICATION_MODAL);
                winStage.setScene(winScene);
                winStage.setX(mainStage.getX() + 150);
                winStage.setY(mainStage.getY() + 150);

                winStage.showAndWait();
            } else {

                try {
                    model.writeScore(model.getPlayer().getPlayerName(), model.getPlayer().getScore());
                } catch (IOException e) {
                    System.err.println("Failed to write players score" + e.getMessage());
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Congratulations!");
                alert.setContentText("You finished the game with a score of " + model.getPlayer().getScore() + "!");
                alert.setTitle("The End");

                Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
                okButton.setOnAction(event -> {
                    goToStartScreen();
                });

                alert.setOnCloseRequest(event -> {
                    goToStartScreen();
                });

                alert.showAndWait();
            }
        }
    }

    private void goToStartScreen() {
        StartView startView = new StartView();
        mainStage.getScene().setRoot(startView);

        new StartPresenter(startView, mainStage);
    }

    private void openSettingsScreen() {
        SettingsView settingsView = new SettingsView();
        Stage settingsStage = new Stage();
        Scene settingsScene = new Scene(settingsView);
        new SettingsPresenter(settingsView, settingsStage, mainStage);

        settingsStage.initModality(Modality.APPLICATION_MODAL);
        settingsStage.initOwner(mainStage);
        settingsStage.setScene(settingsScene);
        settingsStage.setTitle("Settings");
        settingsStage.setWidth(400);
        settingsStage.setHeight(400);
        settingsStage.showAndWait();
    }

    private void openCreditsScreen() {
        CreditsView creditsView = new CreditsView();
        Stage creditsStage = new Stage();
        Scene creditsScene = new Scene(creditsView);
        new CreditsPresenter(creditsView, creditsStage);

        creditsStage.initModality(Modality.APPLICATION_MODAL);
        creditsStage.initOwner(mainStage);
        creditsStage.setScene(creditsScene);
        creditsStage.setTitle("Credits");
        creditsStage.setWidth(400);
        creditsStage.setHeight(400);
        creditsStage.showAndWait();
    }
}
