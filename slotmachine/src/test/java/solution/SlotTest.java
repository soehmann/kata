package solution;

import org.easymock.Capture;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.captureInt;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;

public class SlotTest extends EasyMockSupport {

    private final int length = 27;
    private SlotCollection slotCollection;
    private Slot slot;

    @Before
    public void setUp() throws Exception {
        slotCollection = createMock(SlotCollection.class);
        slot = new Slot(slotCollection);
    }

    @Test
    public void testRandomPlayOff() {
        final Capture<Integer> capture = new Capture<Integer>();

        expect(slotCollection.length()).andReturn(length).anyTimes();
        expect(slotCollection.getValue(captureInt(capture))).andReturn('a').anyTimes();

        replayAll();

        for (int i=0; i < 100000; i++) {
            slot.playOff();
            final int index = capture.getValue();
            assertTrue(index >= 0 && index < length );
        }

        verifyAll();
    }
}
