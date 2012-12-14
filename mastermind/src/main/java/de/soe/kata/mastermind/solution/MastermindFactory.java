package de.soe.kata.mastermind.solution;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;
import de.soe.kata.mastermind.model.Game;
import de.soe.kata.mastermind.model.Guess;
import de.soe.kata.mastermind.services.GameFactory;

@Component
public class MastermindFactory implements GameFactory {
    @Override
    public Game create(final Code code) {
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
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isSolved() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}
