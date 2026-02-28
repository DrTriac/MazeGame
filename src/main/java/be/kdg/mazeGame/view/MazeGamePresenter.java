package be.kdg.mazeGame.view;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the presenter, to connect model and view
 */

import be.kdg.mazeGame.model.Map;
import be.kdg.mazeGame.model.MazeGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        /**view.getButtonOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("OK");
                alert.setHeaderText("Goed gedaan!");
                alert.setContentText("Je hebt op OK gedrukt!");
                alert.showAndWait();
            }
        });*/
    }

    private void updateView() {
        view.drawMap(model.getCurrentMap());
    }


}
