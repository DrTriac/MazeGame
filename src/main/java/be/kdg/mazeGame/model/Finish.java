package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the map element where you finish the maze
 */


public class Finish extends MapElement {
    @Override
    public boolean isWalkable() {
        return true;
    }
}
