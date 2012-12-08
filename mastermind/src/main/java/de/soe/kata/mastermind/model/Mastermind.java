package de.soe.kata.mastermind.model;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * The Game. Contains the secret color code and guesses (rounds).
 * For kata do not change the methods and constructor. Your part is implements the logic and results on it. Especially
 * within create(...) and play(...).
 * Equals, hashCode and toString must be adapt after changes.
 */
public class Mastermind {

    private List<Guess> rounds = Lists.newArrayList();

    private Mastermind() {

    }

    public List<Guess> getRounds() {
        return rounds;
    }

    public List<ColorCode> getColorCodes() {
        return Lists.newArrayList();
    }

    public void play(final Code code) {

    }

    public boolean isSolved() {
        return false;
    }

    public static Mastermind create(final Code code) {
        return new Mastermind();
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

        if(obj instanceof Mastermind) {
            final Mastermind that = (Mastermind)obj;
            return Objects.equal(this.rounds, that.rounds);
        }

        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("rounds", rounds).toString();
    }
}
