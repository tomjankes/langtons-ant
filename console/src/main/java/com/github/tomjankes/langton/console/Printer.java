package com.github.tomjankes.langton.console;

import com.github.tomjankes.langton.Board;
import com.github.tomjankes.langton.State;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Printer {

    private int previousY = 0;

    private void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    public void drawState(Board board, PrintStream out) {
        StringBuilder sb = new StringBuilder();

        board.forEachState((x, y, state) -> {
            if (previousY != y) {
                sb.append("\n");
            }
            if (state == State.BLACK) {
                sb.append("*");
            } else {
                sb.append("0");
            }
            setPreviousY(y);
        });
        out.println(sb.toString());
        setPreviousY(0);
    }

    public void waitForInput(InputStream in) {
        try (Scanner scanner = new Scanner(in)) {
            String s = scanner.nextLine();
            if (s.trim().toLowerCase().equals("q")) {
                throw new ProgramInterruptedException();
            }
        } catch (ProgramInterruptedException e) {
            System.exit(0);
        }
    }


    private static class ProgramInterruptedException extends RuntimeException {

    }
}
