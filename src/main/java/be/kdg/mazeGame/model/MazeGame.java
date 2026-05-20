package be.kdg.mazeGame.model;

import be.kdg.mazeGame.view.gameScreen.SoundManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: Astrid & Thomas
 * Description: class to store and access the game itself
 */

public class MazeGame {
    private final Map currentMap;
    private final Player player;
    private int timeLeft; // in seconds
    private int numberOfPlays;
    private static final int MAX_TIME = 40;
    private static final String SCORE_FILE = System.getProperty("user.home") + "/mazegame_highscores.csv";


    public MazeGame(String playerName, int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;

        char[][] level;
        try {
            level = loadLevel("level" + numberOfPlays);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.currentMap = MapBuilder.fromCharLayout(level);
        this.player = new Player();
        this.player.setPlayerName(playerName);
        this.timeLeft = MAX_TIME;
        int[] start = currentMap.getStartPosition();
        player.setPosition(start[0], start[1]);
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void movePlayer(int row, int column) {
        int newRow = player.getRow() + row;
        int newColumn = player.getColumn() + column;

        if (currentMap.isTileWalkable(newRow, newColumn)) {
            player.setPosition(newRow, newColumn);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void decreaseTime() {
        timeLeft--;
    }

    public boolean finished() {
        int[] finish = currentMap.getEndPosition();
        return player.getRow() == finish[0] && player.getColumn() == finish[1];
    }

    private static char[][] loadLevel(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(MazeGame.class.getResourceAsStream("/be/kdg/mazeGame/Levels/" + filename))))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            char[][] level = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                level[i] = lines.get(i).toCharArray();
            }
            return level;
        }
    }

    public void increaseNumberOfPlays() {
        numberOfPlays++;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }

    public void writeScore(String playerName, int score) throws IOException {
        List<String[]> scores = readScores();
        boolean found = false;

        for (String[] entry : scores) {
            if (entry[0].equals(playerName)) {
                found = true;
                int oldScore = Integer.parseInt(entry[1]);
                if (score > oldScore) {
                    entry[1] = String.valueOf(score);
                }
                break;
            }
        }

        if (!found) {
            scores.add(new String[]{playerName, String.valueOf(score)});
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE, false))) {
            for (String[] entry : scores) {
                writer.write(entry[0] + "," + entry[1]);
                writer.newLine();
            }
        }
    }

    public static List<String[]> readScores() throws IOException {
        List<String[]> scores = new ArrayList<>();
        File file = new File(SCORE_FILE);

        if (!file.exists()) return scores;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] entry = line.split(",");
                if (entry.length < 2) continue;
                scores.add(entry);
            }
        }
        return scores;
    }
}
