package solution;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class SlotCollectionTest {

    private SlotCollection slotCollection;

    @Before
    public void setUp() throws Exception {
        slotCollection = SlotCollection.ALPHA_NUMERIC_DE;
    }

    @Test
    public void getValueByValidIndex() throws Exception {
        assertEquals(slotCollection.getValue(0), Character.valueOf('a'));
    }

    @Test
    public void getValueByOutOfBounds() {
        assertNull(slotCollection.getValue(slotCollection.length()+1));
    }

    @Test
    public void getValueByNegativeIndex() {
        assertNull(slotCollection.getValue(-1));
    }

    @Test
    public void testLength() throws Exception {
        assertEquals(slotCollection.length(), 30);
    }
}
