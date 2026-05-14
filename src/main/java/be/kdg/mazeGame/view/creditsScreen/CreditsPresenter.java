package be.kdg.mazeGame.view.creditsScreen;

import be.kdg.mazeGame.view.settingsScreen.SettingsPresenter;
import be.kdg.mazeGame.view.settingsScreen.SettingsView;
import javafx.scene.Parent;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen to show the credits, to connect model and view
 */

public class CreditsPresenter {
    private CreditsView view;
    private boolean soundOn = true;

    public CreditsPresenter(CreditsView view) {
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(event -> {
            SettingsView settingsView = new SettingsView();
            new SettingsPresenter(settingsView);
            view.getScene().setRoot(settingsView);
        });
    }
}

