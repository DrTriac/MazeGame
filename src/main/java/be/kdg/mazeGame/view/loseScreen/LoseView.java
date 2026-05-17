package be.kdg.mazeGame.view.loseScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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

    public LoseView(int score) {
        initialiseNodes(score);
        layoutNodes();
    }

    private void initialiseNodes(int score) {
        titleLabel = new Label("Game Over!");
        titleLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");

        messageLabel = new Label(String.format("You ran out of time. Your score is: %d.", score));
        messageLabel.setStyle("-fx-font-size: 20px;");

        playAgainButton = new Button("Play Again");
        playAgainButton.setPrefWidth(200);

        menuButton = new Button("Main Menu");
        menuButton.setPrefWidth(200);

        exitButton = new Button("Exit Game");
        exitButton.setPrefWidth(200);
    }

    private void layoutNodes() {
        VBox centerBox = new VBox(20, titleLabel, messageLabel, playAgainButton, menuButton, exitButton);
        centerBox.setAlignment(Pos.CENTER);

        this.setCenter(centerBox);
        this.setPadding(new Insets(40));
    }

    public Button getPlayAgainButton() {
        return playAgainButton;
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
