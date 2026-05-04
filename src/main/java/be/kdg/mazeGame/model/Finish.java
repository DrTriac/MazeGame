package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class for the map element where you finish the maze
 */


public class Finish extends MapElement {
    @Override
    public boolean isWalkable() {
        return true;
    }
}
