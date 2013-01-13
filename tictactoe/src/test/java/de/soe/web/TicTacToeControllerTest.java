package de.soe.web;

import static de.soe.kata.tictactoe.model.GameBoardBuilder.aGameBoard;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import de.soe.kata.tictactoe.model.Game;
import de.soe.kata.tictactoe.model.GameBoard;
import de.soe.kata.tictactoe.services.GameFactory;
import de.soe.kata.tictactoe.services.GameRepository;

public class TicTacToeControllerTest extends EasyMockSupport {

    private GameRepository repository;
    private GameFactory factory;

    private TicTacToeController controller;

    @Before
    public void setUp() throws Exception {
        repository = createMock(GameRepository.class);
        factory = createMock(GameFactory.class);


        controller = new TicTacToeController(repository, factory);
    }

    @Test
    public void test_show_new_game() throws Exception {
        final GameBoard expected = new GameBoard();

        expect(this.repository.find("TIC-TAC-TOE")).andReturn(Optional.<Game>absent());
        replayAll();

        final ModelAndView actual = controller.showGame();

        assertThat(actual.getViewName(), is("tictactoe.play"));
        assertThat(actual.getModel().containsKey("tictactoe"), is(true));
        assertThat(actual.getModel().containsValue(expected), is(true));

        assertThat(actual.getModel().get("tictactoe"), instanceOf(GameBoard.class));

        verifyAll();
    }

    @Test
    public void test_show_found_not_solved_game() throws Exception {
        final Game stub = createGameStub(false, ImmutableMap.of(1,"A"));

        expect(repository.find("TIC-TAC-TOE")).andReturn(Optional.of(stub));
        replayAll();

        final ModelAndView actual = controller.showGame();

        assertThat(actual.getViewName(), is("tictactoe.play"));
        assertThat(actual.getModel().containsKey("tictactoe"), is(true));
        assertThat(actual.getModel().get("tictactoe"), instanceOf(GameBoard.class));
        assertThat((GameBoard)actual.getModel().get("tictactoe"), is(stub.toGameBoard()));

        verifyAll();
    }

    @Test
    public void test_show_solved_game() throws Exception {
        final Game stub = createGameStub(true, ImmutableMap.of(1,"X",2,"O",3,"X"));

        expect(repository.find("TIC-TAC-TOE")).andReturn(Optional.of(stub));
        repository.cleanGameCache();
        replayAll();

        final ModelAndView actual = controller.showGame();

        assertThat(actual.getViewName(), is("tictactoe.play"));
        assertThat(actual.getModel().containsKey("tictactoe"), is(true));
        assertThat((GameBoard)actual.getModel().get("tictactoe"), is(stub.toGameBoard()));

        verifyAll();
    }

    @Test
    public void process_form_fail_to_initialize_game() throws Exception {
        final Game stub = createGameStub(false, ImmutableMap.of(1,"A"));

        expect(repository.find("TIC-TAC-TOE")).andReturn(Optional.<Game>absent());
        expect(factory.create(stub.toGameBoard())).andReturn(Optional.<Game>absent());
        replayAll();

        final ModelAndView actual = controller.playGame(stub.toGameBoard());

        assertThat(actual.getViewName(), is("redirect:/tictactoe"));

        verifyAll();
    }

    @Test
    public void process_form_initialize_game() throws Exception {
        final Game stub = createGameStub(false, ImmutableMap.of(1,"A"));

        expect(repository.find("TIC-TAC-TOE")).andReturn(Optional.<Game>absent());
        expect(factory.create(stub.toGameBoard())).andReturn(Optional.of(stub));
        repository.put("TIC-TAC-TOE", stub);
        replayAll();

        final ModelAndView actual = controller.playGame(stub.toGameBoard());

        assertThat(actual.getViewName(), is("redirect:/tictactoe"));

        verifyAll();
    }

    @Test
    public void process_form_play_game() throws Exception {
        final GameBoard gameBoard = aGameBoard().withContentOnIndex(1,"A").build();
        final Game mock = createMock(Game.class);


        expect(repository.find("TIC-TAC-TOE")).andReturn(Optional.of(mock));
        mock.play(gameBoard);
        repository.put("TIC-TAC-TOE", mock);
        replayAll();

        final ModelAndView actual = controller.playGame(gameBoard);

        assertThat(actual.getViewName(), is("redirect:/tictactoe"));

        verifyAll();
    }

    private Game createGameStub(final boolean solved, final Map<Integer, String> fields) {

        return new Game() {

            @Override
            public void play(final GameBoard gameBoard) {
                //Do nothing
            }

            @Override
            public boolean isSolved() {
                return solved;
            }

            @Override
            public GameBoard toGameBoard() {
                return aGameBoard().withContentMap(fields).build();
            }
        };
    }
}
