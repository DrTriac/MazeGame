package be.kdg.mazeGame.view.winScreen;

import be.kdg.mazeGame.model.MazeGame;

/**
 * Author: Astrid
 * Date: 07/04/2026
 * Description: null.java class for the maze game.
 */
public class WinPresenter {

    private MazeGame model;
    private WinView view;

    public WinPresenter(MazeGame model, WinView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {}

    private void updateView() {}
}
