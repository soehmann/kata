package de.soe.kata.tictactoe.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class GameBoardBuilder {

    private Map<Integer, String> fieldContentMap = Maps.newHashMap();
    private GameBoardBuilder(){}

    public static GameBoardBuilder aGameBoard() {
        return new GameBoardBuilder();
    }

    public GameBoard buildDefault() {
        return new GameBoard();
    }

    public GameBoard build() {
        final GameBoard gameBoard = new GameBoard();
        for (Integer index : fieldContentMap.keySet()) {
            gameBoard.getFields().get(index).setContent(fieldContentMap.get(index));
        }

        return gameBoard;
    }

    public GameBoardBuilder withContentOnIndex(final int index, final String content) {
        fieldContentMap.put(index, content);
        return this;
    }

    public GameBoardBuilder withContentMap(final Map<Integer, String> contentMap) {
        this.fieldContentMap = contentMap;
        return this;
    }
}
