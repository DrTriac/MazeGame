package be.kdg.mazeGame.view;
import be.kdg.mazeGame.model.MazeGame;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class MenuPresenter {
    private MenuView view;
    private MazeGame model;
    private Stage stage;


    public MenuPresenter(MenuView view, MazeGame model, Stage stage) {
        this.view = view;
        this.model = model;
        this.stage = stage;
        addEventHandlers();
        TextureManager.loadImage("menuBackground","/menubg.png");
        view.setBackgroundImage(TextureManager.getImage("menuBackground"));
    }

    private void addEventHandlers() {
        view.getPlayButton().setOnAction(e -> {
            MazeGameView gameView = new MazeGameView();
            MazeGamePresenter gamePresenter = new MazeGamePresenter(gameView, model, stage);
            Scene gameScene = new Scene(gameView, 800, 600);
            stage.setScene(gameScene);
            stage.setTitle("MazeGame");
        });

        view.getSettingsButton().setOnAction(e -> {
            Scene previousScene = stage.getScene(); // capture menu scene
            SettingsView settingsView = new SettingsView();
            SettingsPresenter settingsPresenter = new SettingsPresenter(settingsView, stage, previousScene); // pass it
            Scene settingScene = new Scene(settingsView, 800, 600);
            stage.setScene(settingScene);
            stage.setTitle("settings");
        });
    }


}
