package com.github.tomjankes.langton;

public class Ant {

    private int x;
    private int y;
    private Direction direction;

    public Ant(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveNext(Board board) {
        changeDirection(board.getState(x, y));
        board.switchState(x, y);
        move(board.getWidth(), board.getHeight());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    private void move(int maxX, int maxY) {
        switch (direction) {
            case NORTH:
                increaseY(maxY);
                break;
            case SOUTH:
                decreaseY(maxY);
                break;
            case EAST:
                increaseX(maxX);
                break;
            case WEST:
                decreaseX(maxX);
                break;
        }
    }

    private void changeDirection(State state) {
        switch (state) {
            case BLACK:
                direction = direction.getLeft();
                break;
            case WHITE:
                direction = direction.getRight();
                break;
        }
    }

    private void decreaseX(int maxX) {
        if (x > 0) {
            x--;
        } else {
            x = maxX;
        }
    }

    private void increaseX(int maxX) {
        if (maxX >= x) {
            x++;
        } else {
            x = 0;
        }
    }

    private void increaseY(int maxY) {
        if (maxY >= y) {
            y++;
        } else {
            y = 0;
        }
    }

    private void decreaseY(int maxY) {
        if (y > 0) {
            y--;
        } else {
            y = maxY;
        }
    }
}
