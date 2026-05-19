package be.kdg.mazeGame.model;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;


/**
 * Author: Astrid
 * Date: 18/05/2026
 * Description: null.java class for the maze game.
 */
public class SoundManager {

    private static MediaPlayer player;
    private static void playSong(String filename)
    {
        String path = SoundManager.class.getResource(System.getProperty("user.dir") + "Sounds").toExternalForm();
        Media m = new Media(path);
        player = new MediaPlayer(m);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

    }

    public static void stopMusic() {
        if (player != null) player.stop();
    }

    public static void setVolume(double volume) {
        if (player != null) player.setVolume(volume);
    }

    public static void playTune(String filename) throws NullPointerException
    {
        try {
            playSong(filename);
        } catch (Exception e) {
            System.out.printf("error playing song: %s",filename);
        }

    }

}
