module be.kdg.mazeGame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens be.kdg.mazeGame to javafx.fxml;
    exports be.kdg.mazeGame;
}