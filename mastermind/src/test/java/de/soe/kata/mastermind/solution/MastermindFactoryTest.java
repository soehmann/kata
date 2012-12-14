package de.soe.kata.mastermind.solution;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Game;

public class MastermindFactoryTest {

    private MastermindFactory toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new MastermindFactory();
    }

    @Test
    public void testCreate() throws Exception {
        final Game game = toTest.create(new Code());
        assertThat(game, is(notNullValue(Game.class)));
        assertThat(game.getColorCodes().isEmpty(), is(true));
        assertThat(game.getRounds().isEmpty(), is(true));
        assertThat(game.isSolved(), is(false));
    }
}
