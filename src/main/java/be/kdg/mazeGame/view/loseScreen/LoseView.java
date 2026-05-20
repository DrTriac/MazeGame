package be.kdg.mazeGame.view.loseScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Objects;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the screen when you lose
 */

public class LoseView extends BorderPane {

    private Label titleLabel;
    private Label messageLabel;
    private Button playAgainButton;
    private Button menuButton;
    private Button exitButton;
    private Image background;

    public LoseView(int score) {
        initialiseNodes(score);
        layoutNodes();
    }

    private void initialiseNodes(int score) {
        titleLabel = new Label("Game Over!");
        titleLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold; -fx-text-fill: #DDE6FF;");

        messageLabel = new Label(String.format("You ran out of time. Your score is: %d.", score));
        messageLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #DDE6FF;");

        playAgainButton = new Button("Play Again");
        playAgainButton.setPrefWidth(200);

        menuButton = new Button("Main Menu");
        menuButton.setPrefWidth(200);

        exitButton = new Button("Exit Game");
        exitButton.setPrefWidth(200);

        background = new Image(Objects.requireNonNull(getClass().getResource("/be/kdg/mazeGame/mazebg2.jpg")).toExternalForm());
    }

    private void layoutNodes() {
        VBox centerBox = new VBox(20, titleLabel, messageLabel, playAgainButton, menuButton, exitButton);
        centerBox.setAlignment(Pos.CENTER);

        this.setCenter(centerBox);
        this.setPadding(new Insets(40));

        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(bgImage));
    }

    Button getPlayAgainButton() {
        return playAgainButton;
    }

    Button getMenuButton() {
        return menuButton;
    }

    Button getExitButton() {
        return exitButton;
    }
}
