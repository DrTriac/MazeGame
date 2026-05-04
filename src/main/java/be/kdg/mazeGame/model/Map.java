package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class to store and access the map of the maze.
 */

public class Map {
    private final int height;
    private final int width;
    private final MapElement[][] tiles;
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.tiles = new MapElement[height][width]; // [row][column]
    }

    public MapElement getTile(int row, int column) {
        return tiles[row][column];
    }

    public void setTile(int row, int column, MapElement element) {
        tiles[row][column] = element;
        if (element instanceof Start) {
            startRow = row;
            startColumn = column;
        }
        if (element instanceof Finish) {
            endRow = row;
            endColumn = column;
        }
    }

    public boolean isTileWalkable(int row, int column) {
        if (row < 0 || row >= tiles.length) {
            return false;
        }
        if (column < 0 || column >= tiles[0].length) {
            return false;
        }
        return tiles[row][column].isWalkable();
    }

    public int[] getStartPosition() {
        return new int[]{startRow, startColumn};
    }

    public int [] getEndPosition() {
        return new int[]{endRow, endColumn};
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

