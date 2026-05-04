package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class for the map element where you start the maze
 */

public class Start extends MapElement {
    @Override
    public boolean isWalkable() {
        return true;
    }
}
