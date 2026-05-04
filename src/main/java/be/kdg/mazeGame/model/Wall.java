package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class for the map element wall
 */

public class Wall extends MapElement {
    @Override
    public boolean isWalkable() {
        return false;
    }
}
