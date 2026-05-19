module be.kdg.mazeGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens be.kdg.mazeGame to javafx.fxml;
    exports be.kdg.mazeGame;
}