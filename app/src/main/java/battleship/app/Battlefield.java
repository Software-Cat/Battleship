package battleship.app;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Battlefield extends GridPane {

    private static final AreaRef SIZE = new AreaRef(10, 10);

    private final ArrayGrid<Cell> grid;

    public Battlefield() {
        super();

        // Init grid
        grid = new ArrayGrid<>(SIZE);

        // Padding
        setPadding(new Insets(5));
        setHgap(1);
        setVgap(1);

        // Cells
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                AreaRef ref = new AreaRef(col, row);
                Cell cell = new Cell(ref);
                add(cell, col, row);
                grid.set(ref, cell);
            }
        }
    }
}
