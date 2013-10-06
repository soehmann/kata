package solution;

import java.util.ArrayList;
import java.util.List;

public class Slotmachine {

    private final List<Slot> slots = new ArrayList<Slot>();
    private final WordMatcher matcher;

    public Slotmachine(final List<Slot> slots, final WordMatcher matcher) {
        this.slots.addAll(slots);
        this.matcher = matcher;
    }

    public String play() {
        final String word = runSlots();
        return matcher.matches(word);
    }

    private String runSlots(){

        StringBuilder builder = new StringBuilder();
        for (Slot slot : slots) {
            builder.append(slot.playOff());
        }

        return builder.toString();
    }
}
