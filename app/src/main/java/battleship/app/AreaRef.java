package battleship.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record AreaRef(int column, int row) {

    public static final AreaRef NONEXISTENT = new AreaRef(-1, -1);

    public List<AreaRef> permutations() {
        List<AreaRef> perms = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                perms.add(new AreaRef(columnIndex, rowIndex));
            }
        }

        return Collections.unmodifiableList(perms);
    }
}
