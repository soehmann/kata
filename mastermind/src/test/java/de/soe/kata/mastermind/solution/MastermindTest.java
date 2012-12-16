package de.soe.kata.mastermind.solution;

import static com.google.common.collect.FluentIterable.from;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Splitter;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;

public class MastermindTest {

    private static final String CODE = "RGBY";
    private Mastermind mastermind;

    @Before
    public void setUp() {
        mastermind = new Mastermind(colors(CODE));
    }

    @Test
    public void testGetRounds() throws Exception {
        assertThat(mastermind.getRounds().isEmpty(), is(true));
    }

    @Test
    public void testGetColorCodes() throws Exception {
        assertThat(mastermind.getColorCodes(), is(colorCodes(CODE)));
    }

    @Test
    public void testPlay() throws Exception {
        //ToDo: Play mastermind must be implements.
    }

    @Test
    public void testIsSolved() throws Exception {
        assertThat(mastermind.isSolved(), is(false));
    }

    @Test
    public void testEqualsAndHashCode() {
        //ToDo: Must be implements.
    }

    private List<MastermindColor> colors(final String colors) {
        final Code code = new Code();
        code.setCode(colors);
        return MastermindColor.transform(code);
    }

    private List<ColorCode> colorCodes(final String colors) {
        return from(Splitter.fixedLength(1).split(colors)).transform(new Function<String, ColorCode>() {
            @Override
            public ColorCode apply(final String input) {
                return ColorCode.create(input);
            }
        }).toImmutableList();
    }
}
