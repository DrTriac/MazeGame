package be.kdg.mazeGame.view.gameScreen;

/**
 * Author: Astrid & Thomas
 * Description: class for the graphical representation of the game
 */


import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MazeGameView extends BorderPane {
    private Canvas mazeCanvas;
    private StackPane mazeCanvasWrapper;
    private Label playerLabel;
    private HBox leftBox;
    private Label timingLabel;
    private HBox rightBox;
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem newGame;
    private MenuItem highScores;

    public MazeGameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        mazeCanvas = new Canvas(600, 600);
        mazeCanvasWrapper = new StackPane(mazeCanvas);

        playerLabel = new Label(" ");
        leftBox = new HBox(playerLabel);
        timingLabel = new Label("Time left: 00:00");
        rightBox = new HBox(timingLabel);

        menuBar = new MenuBar();
        menu = new Menu("Maze Game");
        newGame = new MenuItem("New game");
        highScores = new MenuItem("High Scores");

        menu.getItems().addAll(newGame, highScores);
        menuBar.getMenus().add(menu);

        mazeCanvas.setFocusTraversable(true);
    }

    private void layoutNodes() {
        mazeCanvasWrapper.setAlignment(Pos.CENTER);
        this.setCenter(mazeCanvasWrapper);

        leftBox.setAlignment(Pos.CENTER);
        leftBox.setMaxWidth(150);
        leftBox.setMinWidth(150);
        leftBox.setStyle("-fx-background-color: #22303C;");
        this.setLeft(leftBox);
        playerLabel.setStyle("-fx-font-family: 'Consolas'; -fx-text-fill: white; -fx-font-weight: bold;");

        rightBox.setAlignment(Pos.CENTER);
        rightBox.setMaxWidth(150);
        rightBox.setMinWidth(150);
        rightBox.setStyle("-fx-background-color: #22303C;");
        this.setRight(rightBox);
        timingLabel.setStyle("-fx-font-family: 'Consolas'; -fx-text-fill: white; -fx-font-weight: bold;");

        BorderPane.setAlignment(menuBar, Pos.CENTER_LEFT);
        this.setTop(menuBar);
    }

    Canvas getMazeCanvas() {
        return mazeCanvas;
    }

    void drawMap(String[][] mapData, int playerCol, int playerRow, Color playerColor) {
        GraphicsContext gc = mazeCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mazeCanvas.getWidth(), mazeCanvas.getHeight());

        // max cell size = height or width from canvas / number of columns or rows
        // from max height or width you take the smallest number to calculate your cellSize
        // so the maze fits entirely in the canvas
        double cellSize = Math.min(mazeCanvas.getWidth() / mapData.length, mazeCanvas.getHeight() / mapData[0].length);

        // calculate the actual pixel size of the map
        double mazeWidth = mapData.length * cellSize;
        double mazeHeight = mapData[0].length * cellSize;

        // centering the maze in the canvas
        double offsetX = (mazeCanvas.getWidth() - mazeWidth) / 2;
        double offsetY = (mazeCanvas.getHeight() - mazeHeight) / 2; // divided by 2 because you want the same amount of space at the top and bottom of the maze

        for (int row = 0; row < mapData.length; row++) {
            for (int column = 0; column < mapData[0].length; column++) {
                String textureName = mapData[row][column];
                Image texture = TextureManager.getImage(textureName);

                double x = offsetX + column * cellSize;
                double y = offsetY + row * cellSize;

                gc.drawImage(texture, x, y, cellSize, cellSize);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(x, y, cellSize, cellSize);
            }
        }

        double playerX = offsetX + playerCol * cellSize + cellSize / 2;
        double playerY = offsetY + playerRow * cellSize + cellSize / 2;

        gc.setFill(playerColor);
        double radius = cellSize * 0.3;
        gc.fillOval(playerX - radius, playerY - radius, radius * 2, radius * 2);
    }

    public void updateTimer(int timeLeft) {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        timingLabel.setText(String.format("Time left: %02d:%02d", minutes, seconds));
    }

    public void showTimeAlert() {
        Label warning = new Label("HURRY UP!");
        warning.setStyle("-fx-text-fill: red; -fx-font-size: 48px; -fx-font-weight: bold");

        mazeCanvasWrapper.getChildren().add(warning);
        StackPane.setAlignment(warning, Pos.TOP_CENTER);

        FadeTransition ft = new FadeTransition(Duration.millis(500), warning);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }

    Label getPlayerLabel() {
        return playerLabel;
    }

    MenuItem getNewGame() {
        return newGame;
    }

    MenuItem getHighScores() {
        return highScores;
    }
}
