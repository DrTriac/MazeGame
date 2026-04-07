package be.kdg.mazeGame.view.loseScreen;

import be.kdg.mazeGame.model.MazeGame;

/**
 * Author: Astrid
 * Date: 07/04/2026
 * Description: null.java class for the maze game.
 */
public class LosePresenter {
    private MazeGame model;
    private LoseView view;

    public LosePresenter(MazeGame model, LoseView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {}

    private void updateView() {}
}
