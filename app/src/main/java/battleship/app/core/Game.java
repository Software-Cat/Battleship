package battleship.app.core;

import battleship.app.input.Controller;

public class Game {

    private final Agent playerA;

    private final Agent playerB;

    private final Turn turn = Turn.A;

    public Game(Agent playerA, Agent playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }


    public void turn() {

    }

    public enum Turn {
        A, B;

        public Turn next() {
            switch (this) {
                case A -> {
                    return B;
                }
                case B -> {
                    return A;
                }
                default -> throw new IllegalStateException("Unexpected value: " + this);
            }
        }
    }
}
