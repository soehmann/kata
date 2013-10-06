package solution;

import java.util.*;

public class WordMatcher {

    private final Map<String,String> map = new HashMap<String, String>();

    public WordMatcher(final Set<String> words) {
        initialize(words);
    }

    private void initialize(final Set<String> words) {
        for (String word : words) {
            final String wordKey = transform(word);
            map.put(wordKey, word);
        }
    }

    private String transform(final String word) {
        char[] chars = word.toLowerCase(Locale.GERMAN).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public String matches(final String search){
        return map.get(transform(search));
    }
}
