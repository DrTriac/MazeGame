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
            {'#', '.', '.', '.', '.', '#', '.', '#', '#', '#'},
            {'#', '#', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#'},
            {'#', '#', '.', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '.', '#', '#', '#', '#', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public MazeGame(Player player) {
        this.currentMap = MapBuilder.fromCharLayout(LEVEL_ONE);
        this.player = player;
        int[] start = currentMap.getStartPosition();
        player.setPosition(start[0], start[1]);
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void movePlayer(int row, int column) {
        int newRow = player.getRow() + row;
        int newColumn = player.getColumn() + column;

        if (currentMap.isTileWalkable(newRow, newColumn)) {
            player.setPosition(newRow, newColumn);
        }
    }

    public Player getPlayer() {
        return player;
    }
}
