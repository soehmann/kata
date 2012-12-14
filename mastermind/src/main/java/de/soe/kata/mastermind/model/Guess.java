package de.soe.kata.mastermind.model;

import java.util.List;

/**
 * This class represents one attempt to guess the mastermind code. It's contain the colors to try and the the pitches as
 * result from matched colors.
 */
public interface Guess {

    /**
     * @return The color codes of try to guess the mastermind code.
     */
    List<ColorCode> getColors();

    /**
     * @return The result of matched color codes from guess.
     */
    List<ColorCode> getPitches();
}
