package de.soe.kata.mastermind.services;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Game;

/**
 * Creates a new game mastermind from given input code.
 */
public interface GameFactory {

    Game create(final Code code);
}
