package be.kdg.mazeGame.model;

public class Wall extends MapElements{

    private double size = 1.0;
    private double x;
    private double y;

    public Wall(double y, double x, double size) {
        this.y = y;
        this.x = x;
        this.size = size;

    }


    public double getSize() {
        return size;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
