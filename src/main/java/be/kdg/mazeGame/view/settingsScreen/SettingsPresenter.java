package be.kdg.mazeGame.view.settingsScreen;


import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Player;
import be.kdg.mazeGame.view.creditsScreen.CreditsPresenter;
import be.kdg.mazeGame.view.creditsScreen.CreditsView;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.settingsScreen.SettingsView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.scene.paint.Color;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen to change the settings, to connect model and view
 */

public class SettingsPresenter {
    private SettingsView view;
    private boolean soundOn = true;

    public SettingsPresenter(SettingsView view) {
        this.view = view;
        addEventHandlers();
        view.setSoundButtonActive(soundOn);
    }

    private void addEventHandlers() {
        view.getSoundButton().setOnAction(event -> {
            soundOn = !soundOn;
            if (soundOn) {
                view.getSoundButton().setStyle("-fx-font-size: 20px;");
            } else {
                view.getSoundButton().setStyle("-fx-font-size: 20px; -fx-opacity: 0.4;");
            }
        });

        view.getCreditsButton().setOnAction(actionEvent -> {
            CreditsView creditsView = new CreditsView();
            CreditsPresenter creditsPresenter = new CreditsPresenter(creditsView);
            view.getScene().setRoot(creditsView);
        });

        view.getBackButton().setOnAction(event -> {
            StartView startView = new StartView();
            view.getScene().setRoot(startView);
            new StartPresenter(startView);
        });




    }
}

