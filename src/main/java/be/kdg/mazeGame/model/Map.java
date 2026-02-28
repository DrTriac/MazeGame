package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for to store and access the map of the maze.
 */

public class Map {
    private final int height;
    private final int width;
    private final MapElement[][] tiles;

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
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

