package solution;

import java.util.Random;

public class Slot {
    private final SlotCollection slotCollection;

    public Slot(final SlotCollection slotCollection) {
        this.slotCollection = slotCollection;
    }

    public char playOff() {
        return this.slotCollection.getValue(randomIndex());
    }

    private int randomIndex() {
        final Random random = new Random();
        return random.nextInt(this.slotCollection.length());
    }
}
