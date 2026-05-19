package be.kdg.mazeGame.view.startScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the start screen
 */

public class StartView extends BorderPane {
    private Button startButton;
    private Button settingsButton;
    private Label title;
    private VBox vBox;
    private Image background;
    private DropShadow shadow;
    private Label instructions;
    private TextField nameField;
    private ColorPicker colorPicker;

    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        startButton = new Button("Start Game");
        settingsButton = new Button("Settings");
        title = new Label("Maze Game");
        shadow = new DropShadow();
        background = new Image(getClass().getResource("/be/kdg/mazeGame/mazebg2.jpg").toExternalForm());
        instructions = new Label("Instructions:\n- Use the arrow keys to move around the maze.\n- Find the golden star before the timer runs out.");
        nameField = new TextField();
        nameField.setPromptText("Enter your name");
        colorPicker = new ColorPicker(Color.BLUE);
        vBox = new VBox(20, title, instructions, nameField, colorPicker, startButton, settingsButton);
    }

    private void layoutNodes() {
        title.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-font-family: Georgia; -fx-text-fill: #DDE6FF;");
        shadow.setColor(Color.web("#1A2E66"));
        shadow.setRadius(45);
        shadow.setSpread(0.4);
        title.setEffect(shadow);

        instructions.setStyle("-fx-font-size: 16px; -fx-text-fill: #DDE6FF;");
        instructions.setWrapText(true);
        instructions.setTextAlignment(TextAlignment.CENTER);

        nameField.setMaxWidth(200);

        colorPicker.setMaxWidth(200);

        startButton.setStyle("-fx-font-size: 20px;");

        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);

        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(bgImage));
    }

    TextField getNameField() {
        return nameField;
    }

    ColorPicker getColorPicker() {
        return colorPicker;
    }

    Button getStartButton() {
        return startButton;
    }

    Button getSettingsButton() {
        return settingsButton;
    }

}
