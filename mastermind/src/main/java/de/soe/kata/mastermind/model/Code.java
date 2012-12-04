package de.soe.kata.mastermind.model;

import com.google.common.base.Objects;

/**
 * Plain stupid input object from web interface.
 */
public class Code {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
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

        if(obj instanceof Code) {
            final Code that = (Code)obj;
            return Objects.equal(this.code, that.code);
        }

        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("code", code).toString();
    }
}
