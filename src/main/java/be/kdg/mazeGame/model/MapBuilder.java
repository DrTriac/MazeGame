package be.kdg.mazeGame.model;

/**
 * Author: Astrid & Thomas
 * Description: class to build the map from a character layout
 */

public final class MapBuilder {

    private MapBuilder() {
    }

    public static Map fromCharLayout(char[][] layout) {
        int rows = layout.length;
        int columns = layout[0].length;
        Map map = new Map(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                map.setTile(row, column, createElement(layout[row][column]));
            }
        }
        return map;
    }

    private static MapElement createElement(char ch) {
        return switch (ch) {
            case '#' -> new Wall();
            case 'S' -> new Start();
            case 'F' -> new Finish();
            default -> new Floor();
        };
    }
}
