package com.github.tomjankes.langton.swing;

import com.github.tomjankes.langton.Ant;
import com.github.tomjankes.langton.Board;
import com.github.tomjankes.langton.Direction;
import com.github.tomjankes.langton.State;

import static java.util.stream.IntStream.range;

public class Application {

    /* how many iterations to perform */
    private static final int iterations = Integer.MAX_VALUE;
    /* how many iterations should be performed before drawing starts*/
    private static final int startFrom = 8000;
    private static final int boardWidth = 100;
    private static final int boardHeight = 100;
    private static final int zoom = 10;
    private static final long sleep = 10L;

    public static void main(String[] args) {
        Board board = new Board(boardHeight, boardWidth, State.WHITE);
        Ant ant = new Ant(boardWidth / 2, boardHeight / 2, Direction.NORTH);
        range(0, startFrom).forEach(i -> ant.moveNext(board));
        Frame frame = new Frame(board, zoom);
        Updater updater = new Updater(board, ant, frame);
        Thread thread = new Thread(updater);
        thread.start();
    }

    private static class Updater implements Runnable {

        private final Board board;
        private final Ant ant;
        private final Frame frame;

        Updater(Board board, Ant ant, Frame frame) {
            this.board = board;
            this.ant = ant;
            this.frame = frame;
        }

        @Override
        public void run() {
            range(0, iterations).forEach(i -> {
                ant.moveNext(board);
                frame.updateGUI();
                sleep();
            });
        }

        private static void sleep() {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
