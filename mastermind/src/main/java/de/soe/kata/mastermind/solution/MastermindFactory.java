package de.soe.kata.mastermind.solution;

import org.springframework.stereotype.Component;

import com.google.common.base.Optional;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.Game;
import de.soe.kata.mastermind.services.GameFactory;

@Component
public class MastermindFactory implements GameFactory {
    @Override
    public Optional<Game> create(final Code code) {
        return Optional.absent();
    }
}
