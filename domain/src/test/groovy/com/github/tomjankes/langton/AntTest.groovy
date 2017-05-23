package com.github.tomjankes.langton

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class AntTest extends Specification {

    @Shared
    Ant ant = new Ant(50, 50, Direction.NORTH)
    @Shared
    Board board = new Board(100, 100, State.WHITE)

    def "should make correct first step"() {
        when:
        ant.moveNext(board)
        then:
        board.getState(50, 50) == State.BLACK
        ant.x == 51
        ant.y == 50
        ant.direction == Direction.EAST
    }

    def "should make correct second step"() {
        when:
        ant.moveNext(board)
        then:
        board.getState(51, 50) == State.BLACK
        ant.x == 51
        ant.y == 49
        ant.direction == Direction.SOUTH
    }

    def "should make correct third step"() {
        when:
        ant.moveNext(board)
        then:
        board.getState(51, 49) == State.BLACK
        ant.x == 50
        ant.y == 49
        ant.direction == Direction.WEST
    }
}
