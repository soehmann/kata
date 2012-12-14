package de.soe.kata.mastermind.solution;

import static com.google.common.base.Splitter.fixedLength;
import static com.google.common.collect.FluentIterable.from;

import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;

public class MastermindColor {

    public static final Set<MastermindColor> COLORS = ImmutableSet.of(new MastermindColor("R"),
                                                                      new MastermindColor("Y"),
                                                                      new MastermindColor("G"),
                                                                      new MastermindColor("B"),
                                                                      new MastermindColor("O"),
                                                                      new MastermindColor("N"));


    private final String mastermindColor;

    private MastermindColor(final String mastermindColor) {
        this.mastermindColor = mastermindColor;
    }

    public String getMastermindColor() {
        return mastermindColor;
    }

    public boolean isValid() {
        return COLORS.contains(this);
    }

    public static List<MastermindColor> transformFrom(final Code code) {
        return from(fixedLength(1).split(code.getCode())).transform(new Function<String, MastermindColor>() {
            @Override
            public MastermindColor apply(final String color) {
                return new MastermindColor(color.toUpperCase());
            }
        }).toImmutableList();
    }

    public ColorCode toColorCode() {
        return ColorCode.create(this.mastermindColor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mastermindColor);
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj instanceof MastermindColor) {
            final MastermindColor that = (MastermindColor)obj;
            return Objects.equal(this.mastermindColor, that.mastermindColor);
        }

        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("color", this.mastermindColor).toString();
    }
}
