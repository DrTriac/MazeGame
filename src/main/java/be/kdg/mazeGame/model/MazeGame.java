package be.kdg.mazeGame.model;

import java.sql.Time;

public class MazeGame {
    private Map map;
    private Player player;
    private Time time;

    public MazeGame(Player player) {
        this.map = new Map();
        this.player = player;

        // zoek in de map naar de start positie en laat weten aan player waar hij moet gaan staan
        player.setX(map.getStartPosition()[1]);
        player.setY(map.getStartPosition()[0]);
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public void movePlayer(int deltaX, int deltaY)
    {
        int currentX = player.getX();
        int currentY = player.getY();
        int newX = currentX+deltaX;
        int newY = currentY+deltaY;

        if(!map.isWall(newX,newY))
        {
            player.setX(newX);
            player.setY(newY);
        }


    }



}