package be.kdg.mazeGame.view.gameScreen;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the graphical representation of the maze game
 */


import be.kdg.mazeGame.model.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MazeGameView extends BorderPane {
    private Canvas mazeCanvas;
    private StackPane mazeCanvasWrapper;
    private Label playerLabel;
    private Label timingLabel;
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
        timingLabel = new Label("Time left: 00:00");

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

        playerLabel.setAlignment(Pos.CENTER);
        playerLabel.setMaxWidth(Double.MAX_VALUE); //label can take the full width of its region in the borderpane
        BorderPane.setAlignment(playerLabel, Pos.CENTER);
        this.setLeft(playerLabel);

        timingLabel.setAlignment(Pos.CENTER);
        timingLabel.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setAlignment(timingLabel, Pos.CENTER);
        this.setRight(timingLabel);

        BorderPane.setAlignment(menuBar, Pos.CENTER_LEFT);
        this.setTop(menuBar);
    }

    Canvas getMazeCanvas() {
        return mazeCanvas;
    }

    void drawMap(Map map, Player player, Color playerColor) {
        GraphicsContext gc = mazeCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mazeCanvas.getWidth(), mazeCanvas.getHeight());

        // max cell size = height or width from canvas / number of columns or rows
        // from max height or width you take the smallest number to calculate your cellSize
        // so the maze fits entirely in the canvas
        double cellSize = Math.min(mazeCanvas.getWidth() / map.getWidth(), mazeCanvas.getHeight() / map.getHeight());

        // calculate the actual pixel size of the map
        double mazeWidth = map.getWidth() * cellSize;
        double mazeHeight = map.getHeight() * cellSize;

        // centering the maze in the canvas
        double offsetX = (mazeCanvas.getWidth() - mazeWidth) / 2;
        double offsetY = (mazeCanvas.getHeight() - mazeHeight) / 2; // divided by 2 because you want the same amount of space at the top and bottom of the maze

        for (int row = 0; row < map.getHeight(); row++) {
            for (int column = 0; column < map.getWidth(); column++) {
                MapElement element = map.getTile(row, column);

                switch (element) {
                    case Wall w -> gc.setFill(Color.BLACK);
                    case Start s -> gc.setFill(Color.RED);
                    case Finish f -> gc.setFill(Color.GREEN);
                    case Floor f -> gc.setFill(Color.WHITE);
                    default -> gc.setFill(Color.PURPLE);
                }

                double x = offsetX + column * cellSize;
                double y = offsetY + row * cellSize;

                gc.fillRect(x, y, cellSize, cellSize);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(x, y, cellSize, cellSize);
            }
        }

        double playerX = offsetX + player.getColumn() * cellSize + cellSize / 2;
        double playerY =  offsetY + player.getRow() * cellSize + cellSize / 2;

        gc.setFill(playerColor);
        double radius = cellSize * 0.3;
        gc.fillOval(playerX - radius, playerY - radius, radius * 2, radius * 2);
    }

    public void updateTimer(int timeLeft) {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        timingLabel.setText(String.format("Time left: %02d:%02d", minutes, seconds));
    }

    public void showWinMessage(int score) {
        int minutes = score / 60;
        int seconds = score % 60;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You win!");
        alert.setHeaderText(null);
        alert.setContentText(String.format("Congratulations! You escaped the maze with %02d:%02d left.", minutes, seconds));
        alert.showAndWait();
    }

    public void showLoseMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Time's up!");
        alert.setHeaderText(null);
        alert.setContentText("You ran out of time. Try again!");
        alert.showAndWait();
    }

    Label getPlayerLabel() {
        return playerLabel;
    }
}
