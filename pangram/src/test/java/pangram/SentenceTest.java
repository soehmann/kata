package pangram;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class SentenceTest {

    private static final String INPUT = "Franz jagt im komplett verwahrlosten Taxi quer durch Bayern";
    private Sentence toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new Sentence(INPUT);
    }

    @Test
    public void testGetSentence() {
        assertEquals(toTest.getSentence(), INPUT);
    }

    @Test
    public void testGetLetters() {
        final List<String> expected = letters();
        assertEquals(expected, toTest.getLetters());
    }

    private List<String> letters() {
        return Lists.newArrayList(Splitter.fixedLength(1).split("abcdefghijklmnopqrstuvwxyz"));
    }
}
