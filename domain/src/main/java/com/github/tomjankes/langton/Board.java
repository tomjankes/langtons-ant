package com.github.tomjankes.langton;

import static java.util.stream.IntStream.range;

public class Board {

    private final State[][] tiles;
    private final int height;
    private final int width;

    public Board(int height, int width, State initialState) {
        this.height = height;
        this.width = width;
        this.tiles = new State[width][height];
        range(0, width).forEach(x ->
            range(0, height).forEach(y ->
               setState(x, y, initialState)));
    }

    public void forEachState(StateConsumer consumer) {
        range(0, height).forEach(y ->
            range(0, width).forEach(x ->
                consumer.consume(x, y, getState(x, y))));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void setState(int x, int y, State state) {
        synchronized (tiles) {
            tiles[x][y] = state;
        }
    }

    State getState(int x, int y) {
        synchronized (tiles) {
            return tiles[x][y];
        }
    }

    void switchState(int x, int y) {
        synchronized (tiles) {
            tiles[x][y] = tiles[x][y].flip();
        }
    }

    @FunctionalInterface
    public interface StateConsumer {
        void consume(int x, int y, State state);
    }
}
