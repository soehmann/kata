package solution;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.expect;

public class SlotmachineFactoryTest extends EasyMockSupport {

    private static final String fileResource = "myFile";

    private WordResourceReader wordResourceReader;
    private SlotmachineFactory slotmachineFactory;

    @Before
    public void setUp() throws Exception {
        wordResourceReader = createMock(WordResourceReader.class);
        slotmachineFactory = new SlotmachineFactory(wordResourceReader);
    }

    @Test
    public void createSuccessful() throws Exception {
        expect(wordResourceReader.read(fileResource)).andReturn(Collections.EMPTY_SET);
        replayAll();

        assertNotNull(slotmachineFactory.create(fileResource, 1, SlotCollection.ALPHA_NUMERIC_DE));

        verifyAll();
    }

    @Test
    public void creationWithoutResourceShouldHandle() throws Exception {
        expect(wordResourceReader.read(null)).andReturn(Collections.EMPTY_SET);
        replayAll();

        assertNotNull(slotmachineFactory.create(null, 8, SlotCollection.ALPHA_NUMERIC_DE));

        verifyAll();
    }
}
