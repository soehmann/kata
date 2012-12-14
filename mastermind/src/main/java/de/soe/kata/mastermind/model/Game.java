package de.soe.kata.mastermind.model;

import java.util.List;

/**
 * The mastermind Game. Contains the mastermind code to guess and all attempts to solve the game.
 */
public interface Game {

    /**
     * @return The played rounds (guesses).
     */
    List<Guess> getRounds();

    /**
     * @return The color codes to guess of mastermind game.
     */
    List<ColorCode> getColorCodes();

    /**
     * Play a new round and take a guess to solve the mastermind code.
     * @param code Input color code
     */
    void play(final Code code);

    /**
     * @return If he mastermind code is guessed.
     */
    boolean isSolved();
}
