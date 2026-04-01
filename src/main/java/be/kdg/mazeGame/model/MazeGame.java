package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the game itself
 */


public class MazeGame {
    private Map currentMap;
    private Player player;
    private int timeLeft; // in seconds

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

    public MazeGame(String playerName){
        this.currentMap = MapBuilder.fromCharLayout(LEVEL_ONE);
        this.player = new Player();
        this.player.setPlayerName(playerName);
        this.timeLeft = 10;
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

    public int getTimeLeft() {
        return timeLeft;
    }

    public void decreaseTime() {
        timeLeft--;
    }

    public boolean finished() {
        int[] finish = currentMap.getEndPosition();
        return player.getRow() == finish[0] && player.getColumn() == finish[1];
    }
}
