package de.soe.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Mastermind;
import de.soe.kata.mastermind.services.GameRepository;

@Controller
@RequestMapping("/mastermind")
public class MastermindController {

    private static final String key = "MASTERMIND";
    private final GameRepository gameRepository;

    @Autowired
    public MastermindController(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @RequestMapping(method= GET)
    public ModelAndView showForm(){
        return new ModelAndView("mastermind.play", ImmutableMap.<String, Object>of("CODE", new Code()));
    }

    @RequestMapping(value = "/game", method = GET)
    public ModelAndView show(){
        final Optional<Mastermind> optional = this.gameRepository.find(key);
        if(optional.isPresent()) {
            final Mastermind mastermind = optional.get();
            if(mastermind.isSolved()) {
                this.gameRepository.cleanGameCache();
            }
            return new ModelAndView("mastermind.game", ImmutableMap.<String, Object>of("mastermind", mastermind));
        }

        return new ModelAndView("mastermind.game", ImmutableMap.<String, Object>of("mastermind", null));

    }

    @RequestMapping(value = "solution", method = POST)
    public ModelAndView processForm(@ModelAttribute(value="CODE") Code code){
        if(Strings.isNullOrEmpty(code.getCode()) || code.getCode().length() != 4) {
            return new ModelAndView("redirect:");
        }

        playGame(code);

        return new ModelAndView("redirect:/mastermind/game");
    }

    private void playGame(final Code code) {
        final Mastermind mastermind;
        final Optional<Mastermind> optional = this.gameRepository.find(key);
        if(!optional.isPresent()) {
            //Initialize
            mastermind = Mastermind.create(code);
        } else {
            mastermind = optional.get();
            mastermind.play(code);
        }

        this.gameRepository.put(key,mastermind);
    }
}
