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
    private final int TILESIZE = 30;

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

            //maak een graphicsContext om in te kunnen tekenen
            GraphicsContext gc = view.getGC();
            //maak een array van de maparray
            int[][] mapArray = map.getMap();
            //rijen en colommen
            int rows = mapArray.length;
            int cols = mapArray[0].length;

            // geef de map een bepaalde grootte
            double mapWidth = cols * TILESIZE;
            double mapHeight = rows * TILESIZE;
            // maak een canvas aan
            double canvasWidth = view.getGameCanvas().getWidth();
            double canvasHeight = view.getGameCanvas().getHeight();

            // spacing toevoegen om de map te centreren. kan later misschien weg
            double spacingX = (canvasWidth - mapWidth) / 2;
            double spacingY = (canvasHeight - mapHeight) / 2;
            //maak de graphicscontent aan in de canvas
            gc.clearRect(0, 0, canvasWidth, canvasHeight);
            //fillcolor zwart
            gc.setFill(Color.BLACK);
            //ga de map af en teken per 1 in de array een zwart kadertje.
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {

                    if (mapArray[y][x] == 1) {
                        gc.fillRect(
                                spacingX + x * TILESIZE,
                                spacingY + y * TILESIZE, TILESIZE, TILESIZE
                        );
                    }
                }
            }
        }
    }
