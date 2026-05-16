package be.kdg.mazeGame.view.creditsScreen;

import be.kdg.mazeGame.view.settingsScreen.SettingsPresenter;
import be.kdg.mazeGame.view.settingsScreen.SettingsView;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen to show the credits, to connect model and view
 */

public class CreditsPresenter {
    private CreditsView view;
    private Stage stage;
    private boolean soundOn = true;

    public CreditsPresenter(CreditsView view, Stage stage) {
        this.view = view;
        this.stage = stage;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(event -> {
            stage.close();
        });
    }
}

