package de.soe.kata.mastermind.model;

import com.google.common.base.Objects;

/**
 * This general value object represents output of colors within web interface pages.
 */
public class ColorCode {
    private final String code;

    private ColorCode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ColorCode create(final String code) {
        return new ColorCode(code);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.code);
    }

    @Override
    public final boolean equals(final Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof ColorCode) {
            final ColorCode that = (ColorCode)obj;
            return Objects.equal(this.code, that.code);
        }

        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("code", code).toString();
    }
}
