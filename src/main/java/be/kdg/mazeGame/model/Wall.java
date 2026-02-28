package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class for the map element wall
 */

public class Wall extends MapElement {
    @Override
    public boolean isWalkable() {
        return false;
    }
}
