package be.kdg.mazeGame.view;

import be.kdg.mazeGame.model.Wall;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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

    public  Canvas getGameCanvas()
    {
        return  gameCanvas;
    }

    public GraphicsContext getGC()
    {
        //moeten we hebben om te kunnen tekeken. is geen node maar een teken API
        return gameCanvas.getGraphicsContext2D();
    }
}
