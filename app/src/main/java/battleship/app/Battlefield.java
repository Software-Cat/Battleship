package battleship.app;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Battlefield extends GridPane {

    public Battlefield() {
        super();

        setPadding(new Insets(5));
        setHgap(1);
        setVgap(1);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Cell cell = new Cell(new AreaRef(col, row));
                add(cell, col, row);
            }
        }
    }
}
