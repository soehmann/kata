package de.soe.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;
import de.soe.kata.mastermind.model.Game;
import de.soe.kata.mastermind.model.Guess;
import de.soe.kata.mastermind.services.GameFactory;
import de.soe.kata.mastermind.services.GameRepository;

@Controller
@RequestMapping("/mastermind")
public class MastermindController {

    private static final String key = "MASTERMIND";
    private final GameRepository gameRepository;
    private final GameFactory factory;

    @Autowired
    public MastermindController(final GameRepository gameRepository, final GameFactory factory) {
        this.gameRepository = gameRepository;
        this.factory = factory;
    }

    @RequestMapping(method= GET)
    public ModelAndView showForm(){
        return new ModelAndView("mastermind.play", ImmutableMap.<String, Object>of("CODE", new Code()));
    }

    @RequestMapping(value = "/game", method = GET)
    public ModelAndView show(){
        final Optional<Game> optional = this.gameRepository.find(key);
        if(optional.isPresent()) {
            final Game game = optional.get();
            if(game.isSolved()) {
                this.gameRepository.cleanGameCache();
            }
            return new ModelAndView("mastermind.game", ImmutableMap.<String, Object>of("mastermind", game));
        }

        return new ModelAndView("mastermind.game", ImmutableMap.<String, Object>of("mastermind", emptyGame()));

    }

    @RequestMapping(value = "solution", method = POST)
    public ModelAndView processForm(@ModelAttribute(value="CODE") Code code){
        if(Strings.isNullOrEmpty(code.getCode()) || code.getCode().length() != 4) {
            return new ModelAndView("redirect:");
        }

        final Optional<Game> optional = this.gameRepository.find(key);
        if(!optional.isPresent()) {
            initializeGame(code);
        } else {
            playGame(optional.get(), code);
        }

        return new ModelAndView("redirect:/mastermind/game");
    }

    private void playGame(final Game game, final Code code) {
        game.play(code);
        this.gameRepository.put(key, game);
    }

    private void initializeGame(final Code code) {
        final Optional<Game> game = factory.create(code);
        if(!game.isPresent()) {
            return;
        }

        this.gameRepository.put(key,game.get());
    }

    private Game emptyGame() {
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
                //do nothing
            }

            @Override
            public boolean isSolved() {
                return false;
            }
        };
    }
}
