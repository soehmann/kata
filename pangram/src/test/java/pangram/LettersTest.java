package pangram;

import static junit.framework.Assert.assertEquals;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

public class LettersTest {

    private static final String DEFAULT_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private Letters toTest;

    @Before
    public void setUp() throws Exception {
        toTest = Letters.build();
    }

    @Test
    public void testGetDefaultLetters() throws Exception {
        assertEquals(letters(DEFAULT_LETTERS), toTest.getLetters());
    }

    @Test
    public void testDifference() throws Exception {
        assertEquals(letters("xyz"), toTest.difference(letters("abcdefghijklmnopqrstuvw")).getLetters());
    }

    private Set<String> letters(final String input) {
        return Sets.newHashSet(Splitter.fixedLength(1).split(input));
    }
}
