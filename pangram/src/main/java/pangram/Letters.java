package pangram;

import java.util.Set;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class Letters {
    private static final String DEFAULT = "abcdefghijklmnopqrstuvwxyz";
    private final ImmutableSet<String> portion;

    private Letters(final ImmutableSet<String> portion) {
        this.portion = portion;
    }

    public ImmutableSet<String> getLetters() {
        return portion;
    }

    public Letters difference(final Set<String> section) {
        return new Letters(Sets.difference(portion, section).immutableCopy());
    }

    public static Letters build() {
        return new Letters(ImmutableSet.copyOf(Splitter.fixedLength(1).split(DEFAULT)));
    }
}
