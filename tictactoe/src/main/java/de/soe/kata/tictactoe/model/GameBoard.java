package de.soe.kata.tictactoe.model;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * Plain stupid input object (bean) from web interface.
 */
public class GameBoard {

    private String winner;
    private boolean finished = false;
    private List<Field> fields = Lists.newArrayList(
                new Field(), new Field(), new Field(), new Field(), new Field(), new Field(), new Field(),
                new Field(), new Field()
        );

    public GameBoard() {}

    public List<Field> getFields() {
        return this.fields;
    }

    public String getWinnerName() {
        return winner;
    }

    public void setWinnerName(final String name) {
        this.winner = name;
    }

    public boolean isWinner() {
        return !Strings.isNullOrEmpty(winner);
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(final boolean finished) {
        this.finished = finished;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.fields, this.winner, this,finished);
    }

    @Override
    public final boolean equals(final Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof GameBoard) {
            final GameBoard that = (GameBoard)obj;
            return equal(this.fields, that.fields)
                    && equal(this.winner, that.winner)
                    && equal(this.finished, that.finished);
        }

        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("positions", fields)
                                   .add("winner", winner)
                                   .add("finished", finished)
                                   .toString();
    }
}
