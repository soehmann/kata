package de.soe.kata.mastermind.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ColorCodeTest {

    @Test
    public void create_with_null_should_possible() throws Exception {
        assertThat(ColorCode.create(null).getCode(), is(nullValue()));
    }

    @Test
    public void test_create_and_get() throws Exception {
        final String expected = "HUGO";
        assertThat(ColorCode.create(expected).getCode(), is(expected));
    }
}
