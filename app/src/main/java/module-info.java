module battleship.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.collections4;
    requires static lombok;

    exports battleship.app;
    exports battleship.app.core;
    exports battleship.app.input;
}
