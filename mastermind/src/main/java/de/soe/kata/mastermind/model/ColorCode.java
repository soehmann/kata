package de.soe.kata.mastermind.model;

/**
 * Value object, represents output of color code within web interface pages.
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
}
