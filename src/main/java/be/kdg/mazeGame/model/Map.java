package be.kdg.mazeGame.model;

public class Map {
    private int[][] map1 =
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,2,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1},
                    {1,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1,0,1},
                    {1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1},
                    {1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1},
                    {1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
                    {1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1},
                    {1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,1,0,1},
                    {1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1,0,1},
                    {1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,1,0,1},
                    {1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1},
                    {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1},
                    {1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,1},
                    {1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
                    {1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1},
                    {1,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1},
                    {1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,3,1},
                    {1,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1}, {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

    public int[][] getTiles() {
        return map1;
    }

    // start en finish vinden in de map om de player elke keer daar te kunnen zetten.

    public int[] getStartPosition() {
        for (int row = 0; row < map1.length; row++) {
            for (int col = 0; col < map1[0].length; col++) {
                if (map1[row][col] == 2) return new int[]{row, col};
            }
        }
        return new int[]{20, 20}; // handig voor de error detection! als dit 20 returned is er geen start toegevoegd aan de map
    }

    public int[] getFinishPosition() {
        for (int row = 0; row < map1.length; row++) {
            for (int col = 0; col < map1[0].length; col++) {
                if (map1[row][col] == 3) return new int[]{row, col};
            }
        }
        return new int[]{18, 18}; // handig voor de error detecion! als dit 18 returned, is er geen finish toegevoegd aan de map!
    }

    public boolean isWall(int x, int y)
    {
        if(map1[y][x] == 1)
        {
            return true;
        }
        else return false;
    }
}






