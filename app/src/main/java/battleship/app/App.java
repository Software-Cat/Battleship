package battleship.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Test");

        Battlefield battlefield = new Battlefield();

        primaryStage.setScene(new Scene(battlefield, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
