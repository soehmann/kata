package de.soe.kata.mastermind.services;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import de.soe.kata.mastermind.model.Game;

/**
 * Encapsulate the storage of mastermind game. Using google cache, cause of minimalistic implementation overhead.
 */
@Component
public class GameRepository {

    private final Cache<String, Game> cache;

    public GameRepository() {
        this.cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.HOURS).maximumSize(100).build();
    }

    public void put(final String key, final Game game) {
        this.cache.put(key, game);
    }

    public Optional<Game> find(final String key) {
        final Game game = this.cache.getIfPresent(key);
        if(game == null) {
            return Optional.absent();
        }

        return Optional.of(game);
    }

    public void cleanGameCache() {
        this.cache.cleanUp();
    }
}
