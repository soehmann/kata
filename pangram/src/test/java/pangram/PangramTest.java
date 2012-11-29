package pangram;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class PangramTest {

    private static final String INPUT = "abcdefghijklmnopqrstuvwxyz";
    private static final Sentence SENTENCE = new Sentence(INPUT);
    private Pangram toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new Pangram(SENTENCE);
    }

    @Test
    public void testGetPangramSentence() throws Exception {
        assertEquals(toTest.getPangramSentence(), INPUT);
    }

    @Test
    public void testGetAvailableLetters() {
        assertEquals(toTest.getAvailableLetters(), expected(INPUT));
    }

    @Test
    public void testGetMissedLetters() {
        toTest = new Pangram(new Sentence(""));
        assertEquals(toTest.getMissedLetters(), expected(INPUT));
    }

    private List<String> expected(final String input) {
        return Lists.newArrayList(Splitter.fixedLength(1).split(input));
    }
}
