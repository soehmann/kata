package de.soe.kata.mastermind.solution;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIn.isIn;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

import de.soe.kata.mastermind.model.Code;
import de.soe.kata.mastermind.model.ColorCode;

public class MastermindColorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_invalid_color() throws Exception {
        assertThat(toTest("F").isValid(), is(false));
    }

    @Test
    public void test_valid_color() throws Exception {
        assertThat(toTest("G").isValid(), is(true));
    }

    @Test
    public void test_transform_from_invalid_code_to_mastermindColor() {
        final List<MastermindColor> actual = MastermindColor.transformFrom(code("CDEF"));
        assertThat(actual.size(), is(4) );
        for (MastermindColor mastermindColor : actual) {
            assertThat(mastermindColor.isValid(), is(false));
            assertThat(mastermindColor.getMastermindColor(), isIn(Sets.newHashSet("C","D","E","F")));
        }
    }

    @Test
    public void test_transform_from_valid_code_to_mastermindColor() {
        final List<MastermindColor> actual = MastermindColor.transformFrom(code("RBGY"));
        assertThat(actual.size(), is(4) );
        for (MastermindColor mastermindColor : actual) {
            assertThat(mastermindColor.isValid(), is(true));
            assertThat(mastermindColor.getMastermindColor(), isIn(Sets.newHashSet("R","G","B","Y")));
        }
    }

    @Test
    public void test_transform_from_mixed_code_to_mastermindColor() {
        final List<MastermindColor> actual = MastermindColor.transformFrom(code("RVWB"));
        assertThat(actual.size(), is(4) );
        for (MastermindColor mastermindColor : actual) {
            assertThat(mastermindColor.getMastermindColor(), isIn(Sets.newHashSet("R","V","W","B")));
        }
    }

    @Test
    public void test_transform_to_ColorCode() {
        assertThat(toTest("U").toColorCode(), is(ColorCode.create("U")));
    }

    @Test
    public void testEqualsAndHashCode() {
        //ToDo: Must be implements
    }

    private Code code(final String input) {
        final Code code = new Code();
        code.setCode(input);
        return code;
    }

    private MastermindColor toTest(final String color) {
        return MastermindColor.transformFrom(code(color)).get(0);
    }
}
