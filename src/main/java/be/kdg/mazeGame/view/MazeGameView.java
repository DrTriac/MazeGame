package be.kdg.mazeGame.view;

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
    private Label playerName;
    private Label timing;
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
        playerName = new Label("Player 1");
        timing = new Label("00:00:00");

        menuBar = new MenuBar();
        menu = new Menu("Maze Game");
        newGame = new MenuItem("New game");
        highScores = new MenuItem("High Scores");

        menu.getItems().addAll(newGame, highScores);
        menuBar.getMenus().add(menu);
    }

    private void layoutNodes() {
        mazeCanvasWrapper.setAlignment(Pos.CENTER);
        this.setCenter(mazeCanvasWrapper);

        playerName.setAlignment(Pos.CENTER);
        playerName.setMaxWidth(Double.MAX_VALUE); //label can take the full width of its region in the borderpane
        BorderPane.setAlignment(playerName, Pos.CENTER);
        this.setLeft(playerName);

        timing.setAlignment(Pos.CENTER);
        timing.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setAlignment(timing, Pos.CENTER);
        this.setRight(timing);

        BorderPane.setAlignment(menuBar, Pos.CENTER_LEFT);
        this.setTop(menuBar);
    }

    Canvas getMazeCanvas() {
        return mazeCanvas;
    }

    void drawMap(Map map) {
        GraphicsContext gc = mazeCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mazeCanvas.getWidth(), mazeCanvas.getHeight());

        double cellSize = 30;

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

                gc.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(column * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }
}
