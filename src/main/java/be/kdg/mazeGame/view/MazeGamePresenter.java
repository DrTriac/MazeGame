package be.kdg.mazeGame.view;

import be.kdg.mazeGame.model.Map;
import be.kdg.mazeGame.model.Player;
import be.kdg.mazeGame.model.MazeGame;

public class MazeGamePresenter {
    private MazeGameView view;
    private MazeGame model;
    private Map map;
    private Player player;
    private final int TILESIZE = 30;

    public MazeGamePresenter(MazeGameView view, MazeGame model) {
        this.view = view;
        this.model = model;
        this.map = new Map();
        this.player = new Player("Player1");
        loadTextures();
        view.getGameCanvas().widthProperty().addListener((obs, oldV, newV) -> render());
        view.getGameCanvas().heightProperty().addListener((obs, oldV, newV) -> render());
    }

    private void loadTextures() {
        TextureManager.loadImage("stonewall", "/stone_wall_8.png");
    }

    private void render() {
        int[][] mapArray = map.getMap();
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

        double playerScreenX = spacingX + player.getX() * TILESIZE;
        double playerScreenY = spacingY + player.getY() * TILESIZE;
        view.drawPlayer(playerScreenX, playerScreenY, TILESIZE);
    }
}