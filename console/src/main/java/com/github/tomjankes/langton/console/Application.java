package com.github.tomjankes.langton.console;

import com.github.tomjankes.langton.Ant;
import com.github.tomjankes.langton.Board;
import com.github.tomjankes.langton.Direction;
import com.github.tomjankes.langton.State;

import static java.util.stream.IntStream.range;

public class Application {

    private static final int iterations = 500;
    private static final int boardWidth = 100;
    private static final int boardHeight = 100;

    public static void main(String[] args) {
        Board board = new Board(boardHeight, boardWidth, State.WHITE);
        Ant ant = new Ant(boardWidth / 2, boardHeight / 2, Direction.NORTH);
        Printer printer = new Printer();

        range(0, iterations).forEach(i -> ant.moveNext(board));
        printer.drawState(board, System.out);
    }
}
