package be.kdg.mazeGame.view.startScreen;

import be.kdg.mazeGame.model.EmptyNameException;
import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Player;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.gameScreen.SoundManager;
import be.kdg.mazeGame.view.settingsScreen.SettingsPresenter;
import be.kdg.mazeGame.view.settingsScreen.SettingsView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the start screen, to connect model and view
 */

public class StartPresenter {
    private final StartView view;
    private final Stage mainStage;

    public StartPresenter(StartView view, Stage mainStage) {
        this.view = view;
        this.mainStage = mainStage;
        addEventHandlers();
        addWindowEventHandlers();
    }

    private void addEventHandlers() {
        view.getStartButton().setOnAction(event -> {
            try {
                String playerName = view.getNameField().getText();

                if (playerName == null || playerName.isEmpty()) {
                    throw new EmptyNameException("Player name can not be empty!");
                }

                Color playerColor = view.getColorPicker().getValue();

                Player player = new Player();
                player.setPlayerName(playerName);

                MazeGameView gameView = new MazeGameView();
                MazeGame model = new MazeGame(playerName, 1);

                MazeGamePresenter mazeGamePresenter = new MazeGamePresenter(gameView, mainStage, model, playerColor);
                mazeGamePresenter.startTimer();
                SoundManager.playTune("backgroundTrack.mp3");

                view.getScene().setRoot(gameView);
                mainStage.sizeToScene();

            } catch (EmptyNameException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Name");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        });

        view.getSettingsButton().setOnAction(actionEvent -> {
            gotToSettingsScreen();
        });

    }

    public void addWindowEventHandlers() {
        mainStage.setOnCloseRequest(event -> {
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

    private void gotToSettingsScreen() {
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
}
