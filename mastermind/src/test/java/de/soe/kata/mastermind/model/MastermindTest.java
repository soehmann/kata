package de.soe.kata.mastermind.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {

    private Mastermind mastermind;

    @Before
    public void setUp() {
        mastermind = Mastermind.create(new Code());
    }

    @Test
    public void testGetRounds() throws Exception {
        assertThat(mastermind.getRounds().isEmpty(), is(true));
    }

    @Test
    public void testGetColorCodes() throws Exception {
        assertThat(mastermind.getColorCodes().isEmpty(), is(true));
    }

    @Test
    public void testPlay() throws Exception {
        //Must be implements
    }

    @Test
    public void testIsSolved() throws Exception {
        assertThat(mastermind.isSolved(), is(false));
    }

    @Test
    public void testCreate() throws Exception {
        assertThat(Mastermind.create(new Code()), is(notNullValue()));
    }
}
