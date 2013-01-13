package de.soe.kata.tictactoe.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

    private GameBoard toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new GameBoard();
    }

    @Test
    public void test_gameboard_initialized_with_empty_fields() {
        for (Field field : toTest.getFields()) {
            assertThat(field.getContent(), is(nullValue()));
        }
    }

    @Test
    public void testGetFields() throws Exception {
        assertThat(toTest.getFields().size(), is(9));
    }

    @Test
    public void default_winner_Name_is_empty() throws Exception {
        assertThat(toTest.getWinnerName(), is(nullValue()));
    }

    @Test
    public void test_set_winner_Name() throws Exception {
        toTest.setWinnerName("hugo");
        assertThat(toTest.getWinnerName(), is("hugo"));
    }

    @Test
    public void without_name_is_no_winner() throws Exception {
        assertThat(toTest.isWinner(), is(false));
    }

    @Test
    public void has_name_has_winner() throws Exception {
        toTest.setWinnerName("hugo");
        assertThat(toTest.isWinner(), is(true));
    }

    @Test
    public void default_is_not_finished() throws Exception {
        assertThat(toTest.isFinished(), is(false));
    }

    @Test
    public void test_set_finished_is_finished() throws Exception {
        assertThat(toTest.isFinished(), is(false));
        toTest.setFinished(true);
        assertThat(toTest.isFinished(), is(true));
    }

    @Test
    public void testHashCode() throws Exception {
        //ToDo: must be implements
    }
}
