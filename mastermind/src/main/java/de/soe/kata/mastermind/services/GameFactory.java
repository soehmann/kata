package de.soe.kata.mastermind.services;

import com.google.common.base.Optional;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Game;

/**
 * Creates a new game mastermind from given input code.
 */
public interface GameFactory {

    /**
     * @param code Input code to create game with it.
     * @return Create game in case of valid input otherwise it's absent.
     */
    Optional<Game> create(final Code code);
}
