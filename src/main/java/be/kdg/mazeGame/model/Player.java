package be.kdg.mazeGame.model;

/**
 * Author: Astrid
 * Date: 20/02/2026
 * Description: class to make the player and keep the score
 */

public class Player {
    private String name;
    private int score;
    private Color color;
    private double speed;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.score = 0;
        this.speed = 1;
    }

    public String getName() {
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
    }

}
