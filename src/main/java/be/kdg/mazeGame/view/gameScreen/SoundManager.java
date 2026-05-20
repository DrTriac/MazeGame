package be.kdg.mazeGame.view.gameScreen;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;


/**
 * Author: Astrid & Thomas
 * Description: class to manage the sound of the game
 */

public class SoundManager {
    private static MediaPlayer player;

    private static void playSong(String filename)
    {
        String path = Objects.requireNonNull(SoundManager.class.getResource("/be/kdg/mazeGame/Sounds/" + filename)).toExternalForm();
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
