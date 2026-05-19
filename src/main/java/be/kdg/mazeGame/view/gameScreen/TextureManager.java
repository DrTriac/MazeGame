package be.kdg.mazeGame.view.gameScreen;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Astrid & Thomas
 * Description: class to hold all the textures for the map and give them a name
 */

public class TextureManager {
    private static final Map<String, Image> textures = new HashMap<>();

    static Image getImage(String imagename) {
        return textures.get(imagename);
    }

    static void loadImage(String name, String path) {
        textures.put(name, new Image(TextureManager.class.getResource(path).toExternalForm()));
    }
}
