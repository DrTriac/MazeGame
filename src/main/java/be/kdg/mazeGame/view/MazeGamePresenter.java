package be.kdg.mazeGame.view;

import be.kdg.mazeGame.model.Map;
import javafx.scene.paint.Color;
import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.model.Wall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Alert;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;
    private Map map;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {

        this.view = view;
        this.model = model;
        this.map = new Map();
        addEventHandlers();
        //wacht tot canvas klaar is
        view.getGameCanvas().widthProperty().addListener((obs, oldV, newV) -> drawMap());
        view.getGameCanvas().heightProperty().addListener((obs, oldV, newV) -> drawMap());
        updateView();
    }

    private void addEventHandlers() {

    }

    private void draw()
    {

    }

    private void updateView() {}

    private void drawMap(){

            GraphicsContext gc = view.getGC();
            int[][] mapArray = map.getMap();

            int rows = mapArray.length;
            int cols = mapArray[0].length;

            int tileSize = 40;

            // Correct map dimensions
            double mapWidth = cols * tileSize;
            double mapHeight = rows * tileSize;

            // Use CANVAS size, not BorderPane size
        double canvasWidth = view.getGameCanvas().getWidth();
        double canvasHeight = view.getGameCanvas().getHeight();

            // Centering offsets
            double spacingX = (canvasWidth - mapWidth) / 2;
            double spacingY = (canvasHeight - mapHeight) / 2;

            gc.clearRect(0, 0, canvasWidth, canvasHeight);
            gc.setFill(Color.BLACK);

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {

                    if (mapArray[y][x] == 1) {  // FIXED: compare to int
                        gc.fillRect(
                                spacingX + x * tileSize,
                                spacingY + y * tileSize,
                                tileSize,
                                tileSize
                        );
                    }
                }
            }
        }


    }
