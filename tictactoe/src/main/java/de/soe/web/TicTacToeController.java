package de.soe.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import de.soe.kata.tictactoe.model.Game;
import de.soe.kata.tictactoe.model.GameBoard;
import de.soe.kata.tictactoe.services.GameFactory;
import de.soe.kata.tictactoe.services.GameRepository;

@Controller
@RequestMapping("/tictactoe")
public class TicTacToeController {

    private static final String key = "TIC-TAC-TOE";
    private final GameRepository gameRepository;
    private final GameFactory factory;

    @Autowired
    public TicTacToeController(final GameRepository gameRepository, final GameFactory factory) {
        this.gameRepository = gameRepository;
        this.factory = factory;
    }

    @RequestMapping(method= GET)
    public ModelAndView showGame(){
        final Optional<Game> optional = this.gameRepository.find(key);
        if(optional.isPresent()) {
            final Game game = optional.get();
            if(game.isSolved()) {
                this.gameRepository.cleanGameCache();
            }
            return new ModelAndView("tictactoe.play", ImmutableMap.<String, Object>of("tictactoe", game.toGameBoard()));
        }

        return new ModelAndView("tictactoe.play", ImmutableMap.<String, Object>of("tictactoe", new GameBoard()));
    }

    @RequestMapping(value = "play", method = POST)
    public ModelAndView playGame(@ModelAttribute(value="tictactoe") GameBoard gameBoard){
        final Optional<Game> optional = this.gameRepository.find(key);
        if(!optional.isPresent()) {
            initializeGame(gameBoard);
        } else {
            playGame(optional.get(), gameBoard);
        }

        return new ModelAndView("redirect:/tictactoe");
    }

    private void playGame(final Game game, final GameBoard gameBoard) {
        game.play(gameBoard);
        this.gameRepository.put(key, game);
    }

    private void initializeGame(final GameBoard gameBoard) {
        final Optional<Game> game = factory.create(gameBoard);
        if(!game.isPresent()) {
            return;
        }

        this.gameRepository.put(key,game.get());
    }
}
