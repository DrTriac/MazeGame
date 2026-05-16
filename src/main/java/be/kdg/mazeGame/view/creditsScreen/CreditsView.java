package be.kdg.mazeGame.view.creditsScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the screen to show the credits
 */

public class CreditsView extends BorderPane {
    private Button backButton;
    private Label title;
    private VBox vBox;
    private Image background;
    private DropShadow shadow;


    public CreditsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        backButton = new Button("Back");
        title = new Label("Dr_Triac \n ToveFac");
        shadow = new DropShadow();
        background = new Image(getClass().getResource("/be/kdg/mazeGame/mazebg2.jpg").toExternalForm());
        vBox = new VBox(20, title,backButton);
    }

    private void layoutNodes() {
        title.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-font-family: Georgia; -fx-text-fill: #DDE6FF;");
        shadow.setColor(Color.web("#1A2E66"));
        shadow.setRadius(45);
        shadow.setSpread(0.4);
        title.setEffect(shadow);

        backButton.setStyle("-fx-font-size: 20px;");


        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);

        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(bgImage));
    }

    public Button getBackButton()
    {
        return backButton;
    }



}
