package be.kdg.mazeGame.view.gameScreen;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Astrid
 * Date: 12/04/2026
 * Description: class to hold all our textures for the map and give them a name
 */

public class TextureManager {
    //nieuwe hashmap aanmaken voor het stokeren van al onze image adressen en er een naam aan te kunnen linken
    //gaat ervoor zorgan dat we in de presenter al onze textures kunnen initialiseren en ze dan gewoon kunnen gebruiken!

    private static final Map<String, Image> textures = new HashMap<>();

    public static Image getImage(String imagename)
    {
        //geef de passende image terug aan de hand van de naam die door presenter opgevraagd wordt
        return  textures.get(imagename);
    }

    public static void loadImage(String name, String path)
    {
        //om alle textures op te laden, toe te voegen aan onze hash.
        textures.put(name,new Image(TextureManager.class.getResource(path).toExternalForm()));
    }
}
