package de.soe.kata.mastermind.solution;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;
import de.soe.kata.mastermind.model.Game;
import de.soe.kata.mastermind.model.Guess;

public class Mastermind implements Game {

    private List<Guess> rounds = Lists.newArrayList();
    private final List<ColorCode> mastermindCodes;

    public Mastermind(final List<ColorCode> codes) {
        this.mastermindCodes = codes;
    }

    public List<Guess> getRounds() {
        return rounds;
    }

    public List<ColorCode> getColorCodes() {
        return mastermindCodes;
    }

    public void play(final Code code) {

    }

    public boolean isSolved() {
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(rounds, mastermindCodes);
    }

    @Override
    public final boolean equals(final Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof Mastermind) {
            final Mastermind that = (Mastermind)obj;
            return equal(this.rounds, that.rounds)
                    && equal(this.mastermindCodes, that.mastermindCodes);
        }

        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("rounds", rounds)
                                   .add("mastermindCodes", mastermindCodes)
                                   .toString();
    }
}
