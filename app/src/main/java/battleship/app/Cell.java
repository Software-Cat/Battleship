package battleship.app;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Cell extends Button {

    private static final int SIZE = 1000;

    private final AreaRef ref;

    public Cell(AreaRef ref) {
        super();
        this.ref = ref;
        setPrefSize(SIZE, SIZE);
    }
}
