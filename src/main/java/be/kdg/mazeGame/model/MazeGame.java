package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the game itself
 */


import java.sql.Time;

public class MazeGame {
    private Map currentMap;
    private Player player;
    private Time time;

    private static final char[][] LEVEL_ONE = new char[][]{
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '.', '#', '#', '.', '#', '#', '#'},
            {'#', '.', '.', '#', '.', '#', '.', '#', '#', '#'},
            {'#', '#', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#'},
            {'#', '#', '.', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '.', '#', '#', '#', '#', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public MazeGame() {
        this.currentMap = MapBuilder.fromCharLayout(LEVEL_ONE);
    }

    public Map getCurrentMap() {
        return currentMap;
    }


}
