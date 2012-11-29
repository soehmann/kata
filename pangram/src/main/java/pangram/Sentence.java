package pangram;

import static com.google.common.collect.FluentIterable.from;

import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class Sentence {
    private String sentence;

    public Sentence(final String input) {
        this.sentence = input;
    }

    public String getSentence() {
        return sentence;
    }

    public List<String> getLetters() {
        return Lists.newArrayList(Ordering.natural().sortedCopy(transformToLetters(this.sentence)));
    }

    private Set<String> transformToLetters(final String sentence) {
        return from(splitToCharacters(sentence))
                .transform(new Function<String, String>() {
                    public String apply(final String input) {
                        return input.toLowerCase();
                    }
                })
                .filter(new Predicate<String>() {
                    public boolean apply(final String letter) {
                        return !Strings.isNullOrEmpty(letter);
                    }
                }).toImmutableSet();
    }

    private Iterable<String> splitToCharacters(final String input) {
        return Splitter.fixedLength(1).trimResults().split(input);
    }
}
