package be.kdg.mazeGame.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MazeGameView extends BorderPane {
    private Button buttonOk;

    public MazeGameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        buttonOk = new Button("OK");
    }

    private void layoutNodes() {
        this.setCenter(buttonOk);
    }

    Button getButtonOk() {
        return buttonOk;
    }
}
