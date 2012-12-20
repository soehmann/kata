package de.soe.web;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;
import de.soe.kata.mastermind.model.Game;
import de.soe.kata.mastermind.model.Guess;
import de.soe.kata.mastermind.services.GameFactory;
import de.soe.kata.mastermind.services.GameRepository;

public class MastermindControllerTest extends EasyMockSupport {

    private GameRepository repository;
    private GameFactory factory;
    private Game game;

    private MastermindController controller;

    @Before
    public void setUp() throws Exception {
        repository = createMock(GameRepository.class);
        factory = createMock(GameFactory.class);


        controller = new MastermindController(repository, factory);
    }

    @Test
    public void test_show_form() throws Exception {
        final Code expected = new Code();
        replayAll();

        final ModelAndView actual = controller.showForm();

        assertThat(actual.getViewName(), is("mastermind.play"));
        assertThat(actual.getModel().containsKey("CODE"), is(true));
        assertThat(actual.getModel().containsValue(expected), is(true));

        assertThat(actual.getModel().get("CODE"), instanceOf(Code.class));

        verifyAll();
    }

    @Test
    public void test_show_with_no_game_found() throws Exception {

        expect(repository.find("MASTERMIND")).andReturn(Optional.<Game>absent());
        replayAll();

        final ModelAndView actual = controller.show();

        assertThat(actual.getViewName(), is("mastermind.game"));
        assertThat(actual.getModel().containsKey("mastermind"), is(true));
        assertThat(actual.getModel().get("mastermind"), instanceOf(Game.class));

        final Game game = (Game)actual.getModel().get("mastermind");
        assertThat(game.getColorCodes().isEmpty(), is(true));
        assertThat(game.getRounds().isEmpty(), is(true));
        assertThat(game.isSolved(), is(false));

        verifyAll();
    }

    @Test
    public void test_show_with_game_not_solved() throws Exception {
        final Game stub = createGameStub(false);

        expect(repository.find("MASTERMIND")).andReturn(Optional.of(stub));
        replayAll();

        final ModelAndView actual = controller.show();

        assertThat(actual.getViewName(), is("mastermind.game"));
        assertThat(actual.getModel().containsKey("mastermind"), is(true));
        assertThat((Game)actual.getModel().get("mastermind"), is(stub));

        verifyAll();
    }

    @Test
    public void test_show_with_solved_game() throws Exception {
        final Game stub = createGameStub(true);

        expect(repository.find("MASTERMIND")).andReturn(Optional.of(stub));
        repository.cleanGameCache();
        replayAll();

        final ModelAndView actual = controller.show();

        assertThat(actual.getViewName(), is("mastermind.game"));
        assertThat(actual.getModel().containsKey("mastermind"), is(true));
        assertThat((Game)actual.getModel().get("mastermind"), is(stub));

        verifyAll();
    }

    @Test
    public void process_form_fail_to_initialize_game() throws Exception {
        final Code code = new Code();
        code.setCode("ZZZZ");

        expect(repository.find("MASTERMIND")).andReturn(Optional.<Game>absent());
        expect(factory.create(code)).andReturn(Optional.<Game>absent());
        replayAll();

        final ModelAndView actual = controller.processForm(code);

        assertThat(actual.getViewName(), is("redirect:/mastermind/game"));

        verifyAll();
    }

    @Test
    public void process_form_initialize_game() throws Exception {
        final Game stub = createGameStub(false);
        final Code code = new Code();
        code.setCode("GBYO");

        expect(repository.find("MASTERMIND")).andReturn(Optional.<Game>absent());
        expect(factory.create(code)).andReturn(Optional.of(stub));
        repository.put("MASTERMIND", stub);
        replayAll();

        final ModelAndView actual = controller.processForm(code);

        assertThat(actual.getViewName(), is("redirect:/mastermind/game"));

        verifyAll();
    }

    @Test
    public void process_form_play_game() throws Exception {
        final Game mock = createMock(Game.class);
        final Code code = new Code();
        code.setCode("GBYO");

        expect(repository.find("MASTERMIND")).andReturn(Optional.of(mock));
        mock.play(code);
        repository.put("MASTERMIND", mock);
        replayAll();

        final ModelAndView actual = controller.processForm(code);

        assertThat(actual.getViewName(), is("redirect:/mastermind/game"));

        verifyAll();
    }

    @Test
    public void process_form_play_game_with_invalid_colorCode() throws Exception {
        final Code code = new Code();
        code.setCode("ZZZZ");

        expect(repository.find("MASTERMIND")).andReturn(Optional.<Game>absent());
        expect(factory.create(code)).andReturn(Optional.<Game>absent());
        replayAll();

        final ModelAndView actual = controller.processForm(code);

        assertThat(actual.getViewName(), is("redirect:/mastermind/game"));

        verifyAll();
    }

    @Test
    public void process_form_with_invalid_code() throws Exception {
        final Code code = new Code();
        code.setCode("Z");

        replayAll();

        final ModelAndView actual = controller.processForm(code);

        assertThat(actual.getViewName(), is("redirect:"));
        assertThat(actual.getModel().isEmpty(), is(true));

        verifyAll();
    }

    @Test
    public void process_form_with_empty_code() throws Exception {

        replayAll();

        final ModelAndView actual = controller.processForm(new Code());

        assertThat(actual.getViewName(), is("redirect:"));
        assertThat(actual.getModel().isEmpty(), is(true));

        verifyAll();
    }

    private Game createGameStub(final boolean solved) {
        return new Game() {
            @Override
            public List<Guess> getRounds() {
                return Lists.newArrayList();
            }

            @Override
            public List<ColorCode> getColorCodes() {
                return Lists.newArrayList();
            }

            @Override
            public void play(final Code code) {
                //Do nothing
            }

            @Override
            public boolean isSolved() {
                return solved;
            }
        };
    }
}
