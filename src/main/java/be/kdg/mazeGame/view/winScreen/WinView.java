package be.kdg.mazeGame.view.winScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Author: Astrid
 * Date: 07/04/2026
 * Description: null.java class for the maze game.
 */
public class WinView extends BorderPane {

    private Label titleLabel;
    private Label scoreLabel;
    private Button playAgainButton;
    private Button menuButton;
    private Button exitButton;

    public WinView(int score) {
        initialiseNodes(score);
        layoutNodes();
    }

    private void initialiseNodes(int score) {
        titleLabel = new Label("You Win!");
        titleLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");

        int minutes = score / 60;
        int seconds = score % 60;
        scoreLabel = new Label(String.format("You escaped the maze with %02d:%02d left!", minutes, seconds));
        scoreLabel.setStyle("-fx-font-size: 20px;");

        playAgainButton = new Button("Play Again");
        playAgainButton.setPrefWidth(200);

        menuButton = new Button("Main Menu");
        menuButton.setPrefWidth(200);

        exitButton = new Button("Exit Game");
        exitButton.setPrefWidth(200);
    }

    private void layoutNodes() {
        VBox centerBox = new VBox(20, titleLabel, scoreLabel, playAgainButton, menuButton, exitButton);
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
