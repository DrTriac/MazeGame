package be.kdg.mazeGame.view.settingsScreen;

import be.kdg.mazeGame.view.creditsScreen.CreditsPresenter;
import be.kdg.mazeGame.view.creditsScreen.CreditsView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Author: Astrid & Thomas
 * Description: class for the presenter of the screen to change the settings, to connect model and view
 */

public class SettingsPresenter {
    private SettingsView view;
    private Stage stage;
    private Stage mainStage;
    private boolean soundOn = true;

    public SettingsPresenter(SettingsView view, Stage stage, Stage mainStage) {
        this.view = view;
        this.stage = stage;
        this.mainStage = mainStage;
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
        });

        view.getBackButton().setOnAction(event -> {
            stage.close();
        });


    }
}

