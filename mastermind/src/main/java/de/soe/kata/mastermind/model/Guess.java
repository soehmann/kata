package de.soe.kata.mastermind.model;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Guess represents value object of one round to game play mastermind. It's contains the guessed colors and the matched
 * pitches. Please do not change the methods. Only be implements the logic and result within methods and class. Also adapt
 * after changes the equals, hashCode and toString methods.
 */
public class Guess {

    public List<ColorCode> getColors() {
        return Lists.newArrayList();
    }

    public List<ColorCode> getPitches() {
        return Lists.newArrayList();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof Guess) {
            final Guess that = (Guess)obj;
            return Objects.equal(this, that);
        }

        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}
