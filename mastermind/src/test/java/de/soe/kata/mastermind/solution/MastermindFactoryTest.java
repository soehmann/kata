package de.soe.kata.mastermind.solution;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Game;

public class MastermindFactoryTest {

    private static final String COLORS = "BYGR";

    private Code code;
    private MastermindFactory toTest;

    @Before
    public void setUp() throws Exception {
        code = new Code();
        code.setCode(COLORS);

        toTest = new MastermindFactory();
    }

    @Test
    public void testCreate() throws Exception {
        final Optional<Game> game = toTest.create(code);
        assertThat(game.isPresent(), is(false));
    }
}
