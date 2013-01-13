package de.soe.kata.tictactoe.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

    private Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field();
    }

    @Test
    public void testGetContent() throws Exception {
        assertThat(field.getContent(), is(nullValue()));
    }

    @Test
    public void testSetContent() throws Exception {
        assertThat(field.getContent(), is(nullValue()));
        field.setContent("hugo");
        assertThat(field.getContent(), is("hugo"));
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        //ToDo implements test;
    }
}
