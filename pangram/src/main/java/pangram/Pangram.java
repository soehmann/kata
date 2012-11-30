package pangram;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


public class Pangram {

    private final Sentence sentence;

    private Pangram(final Sentence sentence) {
        this.sentence = sentence;
    }

    public String getPangramSentence() {
        return this.sentence.getSentence();
    }

    public List<String> getAvailableLetters() {
        return this.sentence.getLetters();
    }

    public List<String> getMissedLetters() {
        return Lists.newArrayList(getDifference().getLetters());
    }

    private Letters getDifference() {
        return Letters.build().difference(Sets.newHashSet(this.sentence.getLetters()));
    }

    public static Pangram check(final String pangram) {
        return new Pangram(new Sentence(pangram));
    }
}
