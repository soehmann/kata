package solution;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

public class SlotmachineTest extends EasyMockSupport {

    private Slot slot;
    private WordMatcher wordMatcher;
    private final List<Slot> slots = new ArrayList<Slot>();
    private Slotmachine slotmachine;

    @Before
    public void setUp() {
        slot = createMock(Slot.class);
        wordMatcher = createMock(WordMatcher.class);
        slots.add(slot);

        slotmachine = new Slotmachine(slots, wordMatcher);
    }

    @Test
    public void playSuccessful() {
        expect(slot.playOff()).andReturn('a');
        expect(wordMatcher.matches("a")).andReturn("Start");
        replayAll();

        assertEquals(slotmachine.play(), "Start");

        verifyAll();
    }

    @Test
    public void multipleSlots_playInRightOrder() {
        slots.clear();

        final Slot slotA = createStrictMock(Slot.class);
        final Slot slotB = createStrictMock(Slot.class);
        final Slot slotC = createStrictMock(Slot.class);
        slots.add(slotA);
        slots.add(slotB);
        slots.add(slotC);

        slotmachine = new Slotmachine(slots, wordMatcher);

        expect(slotA.playOff()).andReturn('b');
        expect(slotB.playOff()).andReturn('c');
        expect(slotC.playOff()).andReturn('a');
        expect(wordMatcher.matches("bca")).andReturn("Start");

        replayAll();

        assertEquals(slotmachine.play(), "Start");

        verifyAll();
    }
}
