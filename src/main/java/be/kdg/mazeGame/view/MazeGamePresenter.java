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
import javafx.scene.input.KeyEvent;
import be.kdg.mazeGame.view.MazeGameView;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {
        this.view = view;
        this.model = model;

        view.setFocusTraversable(true); // ensures that the view can receive keyboard iput

        addEventHandlers();
        updateView();
    }




    private void addEventHandlers() {
        view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP -> model.movePlayer(-1, 0);
                    case DOWN -> model.movePlayer(1, 0);
                    case RIGHT -> model.movePlayer(0, 1);
                    case LEFT -> model.movePlayer(0, -1);
                }
                updateView();
            }
        });
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
        view.drawMap(model.getCurrentMap(), model.getPlayer());
    }


}
