package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class to make the player and keep the score
 */

public class Player {
    private String playerName;
    /**private int score;*/
    /**private double speed;*/
    private int row;
    private int column;

    public Player() {
        this.playerName = "name";
        this.row = 0;
        this.column = 0;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

/**
    public int getScore() {
        return score;
    }

    public double getSpeed() {
        return speed;
    } */
}
