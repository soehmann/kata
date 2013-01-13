package de.soe.kata.tictactoe.services;

import com.google.common.base.Optional;

import de.soe.kata.tictactoe.model.GameBoard;
import de.soe.kata.tictactoe.model.Game;

/**
 * Creates a new game tictactoe from given first input matrix.
 */
public interface GameFactory {

    /**
     * @param gameBoard Input matrix to create game with it.
     * @return Create new tic tac toe game with first input in case of valid input otherwise it's absent.
     */
    Optional<Game> create(final GameBoard gameBoard);
}
