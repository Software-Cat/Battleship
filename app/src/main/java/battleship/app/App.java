package battleship.app;

import battleship.app.core.Battlefield;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage player1 = new Stage();
        Battlefield battlefield1 = new Battlefield();
        player1.setScene(new Scene(battlefield1, 1000, 1000));

        Stage player2 = new Stage();
        Battlefield battlefield2 = new Battlefield();
        player2.setScene(new Scene(battlefield2, 1000, 1000));

        player1.show();
        player2.show();
    }
}
