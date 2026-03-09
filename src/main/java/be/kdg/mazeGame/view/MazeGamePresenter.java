package be.kdg.mazeGame.view;
import be.kdg.mazeGame.model.MazeGame;

import javafx.scene.input.KeyEvent;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;
    private final int TILESIZE = 30;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {
        this.view = view;
        this.model = model;
        loadTextures();
        view.getGameCanvas().setFocusTraversable(true);
        view.getGameCanvas().requestFocus();



        // wachten tot de stage geladen wordt vppr dat we tekenen!
        view.getGameCanvas().widthProperty().addListener((obs, oldV, newV) -> render());
        view.getGameCanvas().heightProperty().addListener((obs, oldV, newV) -> render());

        view.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) addEventHandlers();
        });


    }

    private void loadTextures() {
        TextureManager.loadImage("stonewall", "/stone_wall_8.png");
    }
    private void addEventHandlers() {
        view.getScene().setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP    -> model.movePlayer(0, -1);
                case DOWN  -> model.movePlayer(0, 1);
                case LEFT  -> model.movePlayer(-1, 0);
                case RIGHT -> model.movePlayer(1, 0);
            }
            render();
        });
    }




    private void render() {
        int[][] mapArray = model.getMap().getTiles();
        int rows = mapArray.length;
        int cols = mapArray[0].length;

        double mapWidth = cols * TILESIZE;
        double mapHeight = rows * TILESIZE;
        double canvasWidth = view.getGameCanvas().getWidth();
        double canvasHeight = view.getGameCanvas().getHeight();

        double spacingX = (canvasWidth - mapWidth) / 2;
        double spacingY = (canvasHeight - mapHeight) / 2;

        view.clearCanvas();
        view.drawMap(mapArray, spacingX, spacingY, TILESIZE);

        double playerScreenX = spacingX + model.getPlayer().getX() * TILESIZE;
        double playerScreenY = spacingY + model.getPlayer().getY() * TILESIZE;
        view.drawPlayer(playerScreenX, playerScreenY, TILESIZE);
    }
}