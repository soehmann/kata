package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordMatcherTest {

    private WordMatcher wordMatcher;

    @Test
    public void matchesSuccessful() throws Exception {
        wordMatcher = new WordMatcher(words());

        assertEquals(wordMatcher.matches("rteow"), "Worte");
        assertEquals(wordMatcher.matches("stet"), "Test");
        assertEquals(wordMatcher.matches("efhrel"), "Fehler");
    }

    @Test
    public void matchesUppercaseSuccessful() throws Exception {
        wordMatcher = new WordMatcher(words());

        assertEquals(wordMatcher.matches("EfHReL"), "Fehler");
    }

    @Test
    public void matchesNotFound() throws Exception {
        wordMatcher = new WordMatcher(words());

        assertEquals(wordMatcher.matches("abc"), null);
    }

    private Set<String> words() {
        final Set<String> words = new HashSet<String>();
        words.add("Worte");
        words.add("Test");
        words.add("Fehler");
        return words;
    }
}
