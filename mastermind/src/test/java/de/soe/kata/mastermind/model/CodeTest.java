package de.soe.kata.mastermind.model;

import static de.soe.kata.mastermind.model.CodeTest.Builder.aCode;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CodeTest {

    public void instantiate_should_contain_empty_code() throws Exception {
        final Code code = new Code();
        assertThat(code.getCode(), is(nullValue()));
    }

    @Test
    public void testSetCode() throws Exception {
        final String expected = "HUGO";
        final Code code = new Code();
        code.setCode(expected);

        assertThat(code, is(aCode().withCode(expected).build()));
    }

    @Test
    public void testGetCode() {
        final String expected = "HUGO";
        final Code code = aCode().withCode(expected).build();

        assertThat(code.getCode(), is(expected));
    }

    static class Builder {
        private String value = null;

        private Builder() {}

        public static Builder aCode() {
            return new Builder();
        }

        public Builder withCode(final String value) {
            this.value = value;
            return this;
        }

        public Code build() {
            final Code code = new Code();
            code.setCode(value);
            return code;
        }
    }
}
