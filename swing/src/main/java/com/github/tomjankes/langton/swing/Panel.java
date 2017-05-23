package com.github.tomjankes.langton.swing;

import com.github.tomjankes.langton.Board;
import com.github.tomjankes.langton.State;

import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {

    private final Board board;
    private final int zoom;

    Panel(Board board, int zoom) {
        this.board = board;
        this.zoom = zoom;
    }

    @Override
    public void paint(Graphics g) {
        board.forEachState((x, y, state) -> {
            g.setColor(state == State.BLACK ? Color.BLACK : Color.WHITE);
            g.fillRect((x * zoom) - (zoom /2), (y * zoom) - (zoom / 2), zoom, zoom);
        });
        setSize(board.getWidth() * zoom - zoom, board.getHeight() * zoom - zoom);
    }
}
