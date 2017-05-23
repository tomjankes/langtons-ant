package com.github.tomjankes.langton;

public enum State {

    WHITE, BLACK;

    public State flip() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
