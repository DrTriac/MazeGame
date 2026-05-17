package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class to store the player, its position and keep the score
 */

public class Player {
    private String playerName;
    private int row;
    private int column;
    private int score;

    public Player() {
        this.playerName = "name";
        this.row = 0;
        this.column = 0;
        this.score = 0;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

}
