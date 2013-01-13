package de.soe.kata.tictactoe.services;

import static de.soe.kata.tictactoe.model.GameBoardBuilder.aGameBoard;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;

import de.soe.kata.tictactoe.model.Game;

public class TicTacToeFactoryTest {

    private TicTacToeFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new TicTacToeFactory();
    }

    @Test
    public void testCreate() throws Exception {
        assertThat(factory.create(aGameBoard().buildDefault()), is(Optional.<Game>absent()));
    }
}
