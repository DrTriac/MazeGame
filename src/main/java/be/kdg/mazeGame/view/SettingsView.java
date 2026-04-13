package be.kdg.mazeGame.view;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class SettingsView extends BorderPane {
    private Canvas settingsCanvas;
    private Button fxButton;
    private Button volumeButton;
    private Button backButton;
    private VBox buttonBox;

    public SettingsView()
    {
        initialiseNodes();
        layoutNodes();
    }

    public void initialiseNodes() {
        settingsCanvas = new Canvas();
        settingsCanvas.setWidth(600);
        settingsCanvas.setHeight(800);
        settingsCanvas.widthProperty().bind(this.widthProperty());
        settingsCanvas.heightProperty().bind(this.heightProperty());
        buttonBox = new VBox(10);
        volumeButton = new Button("VOLUME");
        fxButton = new Button("FX");
        backButton = new Button("Back");
        buttonBox.getChildren().addAll(backButton, fxButton, volumeButton);
         ;

    }

    public void layoutNodes()
    {
        this.setCenter(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);

    }

    public Button getBackButton()
    {
        return backButton;
    }

    public Button getFxButton() {
        return fxButton;
    }

    public Button getVolumeButton() {
        return volumeButton;
    }
}

