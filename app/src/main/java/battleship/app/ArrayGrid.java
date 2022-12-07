package battleship.app;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.list.FixedSizeList;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Accessors(fluent = true)
public class ArrayGrid<T> {

    private final List<List<T>> grid;

    @Getter
    private final AreaRef size;

    public ArrayGrid(AreaRef size) {
        this.size = size;

        List<List<T>> columns = new ArrayList<>();
        for (int row = 0; row < size.row(); row++) {
            List<T> currentRow = new ArrayList<>();
            for (int i = 0; i < size.column(); i++) {
                currentRow.add(null);
            }
            columns.add(FixedSizeList.fixedSizeList(currentRow));
        }
        grid = FixedSizeList.fixedSizeList(columns);
    }

    public boolean isEmpty() {
        return grid.stream().map(
                row -> row.stream().map(
                        Objects::isNull
                ).reduce(false, (a, b) -> a || b)
        ).reduce((a, b) -> a || b).orElse(true);
    }

    public boolean contains(Object o) {
        return grid.stream().map(
                row -> row.stream().map(
                        cell -> cell == o
                ).reduce(false, (a, b) -> a || b)
        ).reduce((a, b) -> a || b).orElse(false);
    }

    public boolean remove(Object o) {
        T ret = remove(indexOf(o));
        return ret != null;
    }

    public boolean containsAll(Collection<?> c) {
        return c.stream().map(this::contains).reduce((a, b) -> a && b).orElse(false);
    }


    public boolean removeAll(Collection<?> c) {
        AtomicBoolean modified = new AtomicBoolean(false);
        c.stream().map(item -> {
            this.remove(item);
            modified.set(true);
            return null;
        });
        return modified.get();
    }

    public void clear() {
        for (AreaRef ref : size.permutations()) {
            remove(ref);
        }
    }

    public T get(AreaRef ref) {
        return grid.get(ref.column()).get(ref.row());
    }

    public T set(AreaRef ref, T element) {
        return grid.get(ref.column()).set(ref.row(), element);
    }

    public T remove(AreaRef ref) {
        return set(ref, null);
    }

    public AreaRef indexOf(Object o) {
        for (AreaRef ref : size.permutations()) {
            if (get(ref) == o) {
                return ref;
            }
        }
        return AreaRef.NONEXISTENT;
    }
}
