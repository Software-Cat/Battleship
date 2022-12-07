package battleship.app;

import javafx.scene.control.Button;

public class Cell extends Button {

    private final AreaRef ref;

    public Cell(AreaRef ref) {
        super();
        this.ref = ref;
        setPrefSize(1000, 1000);
    }
}
