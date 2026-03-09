package be.kdg.mazeGame.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class MazeGameView extends BorderPane {
    private Canvas gameCanvas;

    public MazeGameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        gameCanvas = new Canvas();
        gameCanvas.setHeight(600);
        gameCanvas.setWidth(800);
        gameCanvas.widthProperty().bind(this.widthProperty());
        gameCanvas.heightProperty().bind(this.heightProperty());
    }

    private void layoutNodes() {
        this.setCenter(gameCanvas);
    }

    public Canvas getGameCanvas() {
        return gameCanvas;
    }

    public GraphicsContext getGC() {
        return gameCanvas.getGraphicsContext2D();
    }

    public void clearCanvas() {
        GraphicsContext gc = getGC();
        gc.clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
    }

    public void drawMap(int[][] mapArray, double spacingX, double spacingY, int tileSize) {
        GraphicsContext gc = getGC();
        for (int y = 0; y < mapArray.length; y++) {
            for (int x = 0; x < mapArray[0].length; x++) {
                if (mapArray[y][x] == 1) {
                    gc.drawImage(TextureManager.getImage("stonewall"), spacingX + x * tileSize, spacingY + y * tileSize, tileSize, tileSize);
                }
            }
        }
    }

    public void drawPlayer(double screenX, double screenY, int tileSize) {
        GraphicsContext gc = getGC();
        gc.setFill(Color.BLUE);
        gc.fillOval(screenX + 2, screenY + 2, tileSize - 4, tileSize - 4);
    }
}