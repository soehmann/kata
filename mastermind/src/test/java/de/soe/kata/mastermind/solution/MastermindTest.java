package de.soe.kata.mastermind.solution;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MastermindTest {

    private Mastermind mastermind;

    @Before
    public void setUp() {
        mastermind = new Mastermind(Lists.<MastermindColor>newArrayList());
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
}
