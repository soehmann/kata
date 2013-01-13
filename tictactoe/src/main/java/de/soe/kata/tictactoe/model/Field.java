package de.soe.kata.tictactoe.model;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;

import com.google.common.base.Objects;

public class Field {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.content);
    }

    @Override
    public final boolean equals(final Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof Field) {
            final Field that = (Field)obj;
            return equal(this.content, that.content);
        }

        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("content", content)
                                   .toString();
    }
}
