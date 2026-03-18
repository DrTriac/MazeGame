package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class to make the player and keep the score
 */

import javafx.scene.paint.Color;

public class Player {
    private String playerName;
    /**private int score;*/
    private Color playerColor;
    /**private double speed;*/
    private int row;
    private int column;

    public Player() {
        this.playerName = "name";
        this.playerColor = Color.BLUE;
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

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

/**
    public int getScore() {
        return score;
    }

    public double getSpeed() {
        return speed;
    } */
}
