package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SlotmachineFactory {

    private final WordResourceReader wordResourceReader;

    public SlotmachineFactory(WordResourceReader wordResourceReader) {
        this.wordResourceReader = wordResourceReader;
    }

    public Slotmachine create(final String resource, final int slotCount, final SlotCollection collection) {
        final Set<String> wordPool = wordResourceReader.read(resource);
        final List<Slot> slots = new ArrayList<Slot>();
        for (int i = 0; i < slotCount; i++) {
            slots.add(new Slot(collection));
        }

        return new Slotmachine(slots, new WordMatcher(wordPool));
    }
}
