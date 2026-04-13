package be.kdg.mazeGame.view;
import be.kdg.mazeGame.model.MazeGame;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsPresenter {
    private SettingsView view;
    private Stage stage;
    private Scene previousScene;
    private MazeGame model;

    public SettingsPresenter(SettingsView view, Stage stage, Scene previousScene)
    {
        this.view = view;
        this.stage = stage;
        this.previousScene = previousScene;
        addEventHandlers();
    }

    private void addEventHandlers()
    {
        view.getBackButton().setOnAction(e -> {
            stage.setScene(previousScene);
            stage.setTitle("Main Menu");
        });


    }




}
