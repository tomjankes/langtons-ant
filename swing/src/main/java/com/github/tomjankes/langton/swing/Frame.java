package com.github.tomjankes.langton.swing;

import com.github.tomjankes.langton.Board;

import javax.swing.*;
import java.awt.*;

class Frame extends JFrame {

    private final Panel panel;

    Frame(Board board, int zoom) throws HeadlessException {
        panel = new Panel(board, zoom);
        add(panel);
        setSize(zoom * board.getWidth(), zoom * board.getHeight() + 30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void updateGUI() {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(this::updateGUI);
            return;
        }
        panel.repaint();
    }
}
