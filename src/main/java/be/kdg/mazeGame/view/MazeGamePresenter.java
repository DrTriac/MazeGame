package be.kdg.mazeGame.view;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the presenter, to connect model and view
 */

import be.kdg.mazeGame.model.MazeGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;
    private Timeline timer;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {
        this.view = view;
        this.model = model;

        view.setFocusTraversable(true); // ensures that the view can receive keyboard iput

        addEventHandlers();
        updateView();
        startTimer();

        Platform.runLater(() -> view.getMazeCanvas().requestFocus()); // request focus on the canvas after the window appears
    }

    private void addEventHandlers() {
        view.getMazeCanvas().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                    case UP -> model.movePlayer(-1, 0);
                    case DOWN -> model.movePlayer(1, 0);
                    case RIGHT -> model.movePlayer(0, 1);
                    case LEFT -> model.movePlayer(0, -1);
                }
                updateView();
                checkWinCondition();
        });
    }

    private void updateView() {
        view.drawMap(model.getCurrentMap(), model.getPlayer());
    }

    public void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            model.decreaseTime();
            view.updateTimer(model.getTimeLeft());
            if (model.getTimeLeft() <= 0) {
                timer.stop();
                Platform.runLater(() -> view.showLoseMessage()); // to fix error "showAndWait is not allowed during animation or layout processing"
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void checkWinCondition() {
        if (model.finished()) {
            timer.stop();
            int score = model.getTimeLeft();
            /**saveHighScore(score);*/
            view.showWinMessage(score);
        }

    }


}
