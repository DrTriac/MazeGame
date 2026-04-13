package be.kdg.mazeGame.view;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MenuView extends BorderPane {
    private Canvas menuCanvas;
    private Button playButton;
    private Button settingsButton;
    private Button quitButton;
    private VBox buttonBox;

    public MenuView() {

        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        menuCanvas = new Canvas();
        menuCanvas.setHeight(600);
        menuCanvas.setWidth(800);
        menuCanvas.widthProperty().bind(this.widthProperty());
        menuCanvas.heightProperty().bind(this.heightProperty());
        buttonBox = new VBox(10);
        playButton= new Button("START GAME");
        settingsButton = new Button("SETTINGS");
        quitButton = new Button("QUIT");
        buttonBox.getChildren().addAll(playButton,settingsButton,quitButton);
    }

    private void layoutNodes() {
        this.setCenter(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);



    }

    public Canvas getmenuCanvas() {
        return menuCanvas;
    }

    public GraphicsContext getGC() {
        return menuCanvas.getGraphicsContext2D();
    }

    public void clearCanvas() {
        GraphicsContext gc = getGC();
        gc.clearRect(0, 0, menuCanvas.getWidth(), menuCanvas.getHeight());
    }



    public Button getPlayButton()
    {
        return playButton;
    }

    public Button getSettingsButton()
    {
        return settingsButton;
    }

    public void setBackgroundImage(Image image)
    {
        BackgroundImage bg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true, false, true));
        this.setBackground(new Background(bg));
    }


}