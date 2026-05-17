package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class for the exception that gets thrown when the player name is empty.
 */

public class EmptyNameException extends Exception {
    public EmptyNameException(String message) {
        super(message);
    }
}
