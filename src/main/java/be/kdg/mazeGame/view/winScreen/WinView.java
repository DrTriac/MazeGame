package be.kdg.mazeGame.view.winScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the screen when you win
 */

public class WinView extends BorderPane {

    private Label titleLabel;
    private Label scoreLabel;
    private Button nextLevelButton;
    private Button menuButton;
    private Button exitButton;

    public WinView(int score, int timeLeft) {
        initialiseNodes(timeLeft, score);
        layoutNodes();
    }

    private void initialiseNodes(int timeleft, int score) {
        titleLabel = new Label("You Win!");
        titleLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");

        int minutes = timeleft / 60;
        int seconds = timeleft % 60;
        scoreLabel = new Label(String.format("You escaped the maze with %02d:%02d left! Your score is: %d.", minutes, seconds, score));
        scoreLabel.setStyle("-fx-font-size: 20px;");

        nextLevelButton = new Button("Next Level");
        nextLevelButton.setPrefWidth(200);

        menuButton = new Button("Main Menu");
        menuButton.setPrefWidth(200);

        exitButton = new Button("Exit Game");
        exitButton.setPrefWidth(200);
    }

    private void layoutNodes() {
        VBox centerBox = new VBox(20, titleLabel, scoreLabel, nextLevelButton, menuButton, exitButton);
        centerBox.setAlignment(Pos.CENTER);

        this.setCenter(centerBox);
        this.setPadding(new Insets(40));
    }

    public Button getNextLevelButton() {
        return nextLevelButton;
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
