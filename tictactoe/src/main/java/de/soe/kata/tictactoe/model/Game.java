package de.soe.kata.tictactoe.model;

public interface Game {

    void play(final GameBoard gameBoard);
    boolean isSolved();
    GameBoard toGameBoard();
}
