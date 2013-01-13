package de.soe.kata.tictactoe.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;

import de.soe.kata.tictactoe.model.Game;
import de.soe.kata.tictactoe.model.GameBoard;

public class GameRepositoryTest {

    private GameRepository toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new GameRepository();
    }

    @Test
    public void testPut() throws Exception {
        final Game game = new GameStub();
        assertThat(toTest.find("BLUB"), is(Optional.<Game>absent()));

        toTest.put("BLUB", game);

        assertThat(toTest.find("BLUB"), is(Optional.of(game)));
    }

    @Test
    public void try_find_on_empty_cache() throws Exception {
        assertThat(toTest.find("BLUB"), is(Optional.<Game>absent()));
    }

    @Test
    public void try_find_on_stored_game() throws Exception {
        final Game game = new GameStub();
        toTest.put("BLUB", game);

        assertThat(toTest.find("BLUB"), is(Optional.of(game)));
    }

    @Test
    public void testCleanGameCache() throws Exception {
        final Game game = new GameStub();
        toTest.put("BLUB", game);
        assertThat(toTest.find("BLUB"), is(Optional.of(game)));

        toTest.cleanGameCache();

        assertThat(toTest.find("BLUB"), is(Optional.<Game>absent()));
    }

    private class GameStub implements Game {

        @Override
        public void play(final GameBoard gameBoard) {}

        @Override
        public boolean isSolved() {
            return false;
        }

        @Override
        public GameBoard toGameBoard() {
            return null;
        }
    }
}
