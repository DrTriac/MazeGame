package be.kdg.mazeGame.view.settingsScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the screen to change the settings
 */

public class SettingsView extends BorderPane {
    private Button creditsButton;
    private Button soundButton;
    private Button backButton;
    private Label title;
    private VBox vBox;
    private Image background;
    private DropShadow shadow;

    public SettingsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        soundButton = new Button("Sound");
        creditsButton = new Button("Credits");
        backButton = new Button("Back");
        title = new Label("Settings");
        shadow = new DropShadow();
        background = new Image(getClass().getResource("/be/kdg/mazeGame/mazebg2.jpg").toExternalForm());
        vBox = new VBox(20, title, soundButton, creditsButton, backButton);
    }

    private void layoutNodes() {
        title.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-font-family: Georgia; -fx-text-fill: #DDE6FF;");
        shadow.setColor(Color.web("#1A2E66"));
        shadow.setRadius(45);
        shadow.setSpread(0.4);
        title.setEffect(shadow);

        soundButton.setStyle("-fx-font-size: 20px;");
        creditsButton.setStyle("-fx-font-size: 20px;");

        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);

        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(bgImage));
    }

    Button getSoundButton() {
        return soundButton;
    }

    Button getBackButton() {
        return backButton;
    }

    Button getCreditsButton() {
        return creditsButton;
    }

    void setSoundButtonActive(boolean active) {
        soundButton.setStyle("-fx-font-size: 20px;" + (active ? "" : " -fx-opacity: 0.4;"));
    }
}
