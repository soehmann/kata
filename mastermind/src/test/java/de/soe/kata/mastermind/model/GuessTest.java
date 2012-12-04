package de.soe.kata.mastermind.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GuessTest {

    private Guess guess;

    @Before
    public void setUp() {
        guess = new Guess();
    }

    @Test
    public void testGetColors() throws Exception {
        assertThat(guess.getColors().isEmpty(), is(true));
    }

    @Test
    public void testGetPitches() throws Exception {
        assertThat(guess.getPitches().isEmpty(), is(true));
    }
}
