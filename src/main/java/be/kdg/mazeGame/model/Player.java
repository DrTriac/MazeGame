package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class to make the player and keep the score
 */

public class Player {
    /** private String name;
    private int score;
    private Color color;
    private double speed;*/
    private int row;
    private int column;

    public Player() {
        this.row = 0;
        this.column = 0;
    }

    public Player(int row, int column) {
        /** this.name = name;
        this.color = color;
        this.score = 0;
        this.speed = 1; */
        this.row = row;
        this.column = column;
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

    /** public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    } */
}
