package be.kdg.mazeGame.view.loseScreen;

import be.kdg.mazeGame.model.MazeGame;
import be.kdg.mazeGame.view.gameScreen.MazeGamePresenter;
import be.kdg.mazeGame.view.gameScreen.MazeGameView;
import be.kdg.mazeGame.view.startScreen.StartPresenter;
import be.kdg.mazeGame.view.startScreen.StartView;
import be.kdg.mazeGame.view.winScreen.WinView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Author: Astrid
 * Date: 07/04/2026
 * Description: null.java class for the maze game.
 */
public class LosePresenter {
    private MazeGame model;
    private Color playerColor;
    private LoseView view;
    private Stage loseStage;
    private Stage mainStage;

    public LosePresenter(MazeGame model, Color playerColor, LoseView view, Stage loseStage, Stage  mainStage) {
        this.model = model;
        this.playerColor = playerColor;
        this.view = view;
        this.loseStage = loseStage;
        this.mainStage = mainStage;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getPlayAgainButton().setOnAction(event -> {
            playAgain();
        });

        view.getMenuButton().setOnAction(event -> {
            goToStartScreen();
        });

        view.getExitButton().setOnAction(event -> {
            System.exit(0);
        });
    }

    private void updateView() {}

    private void playAgain() {
        loseStage.close();

        MazeGameView mazeGameView = new MazeGameView();
        MazeGame newModel = new MazeGame(model.getPlayer().getPlayerName());
        new MazeGamePresenter(mazeGameView, newModel, playerColor);

        mainStage.getScene().setRoot(mazeGameView);
        mainStage.sizeToScene();
    }

    private void goToStartScreen() {
        loseStage.close();

        StartView startView = new StartView();
        new StartPresenter(startView);

        mainStage.getScene().setRoot(startView);
    }
}
