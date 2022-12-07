package battleship.app;

public record AreaRef(int column, int row) {

    public AreaRef {
        assert column >= 0;
        assert row >= 0;
    }
}
