package refactoring;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.eq;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

public class BackendOrderSynServiceTest extends EasyMockSupport {

    private static BackendOrderSynService serviceToTest;
    private Processor processor;
    private ProcessedOrderValidator orderValidator;

    @Before
    public void setUp() throws Exception {
        processor = createMock(Processor.class);
        orderValidator = createMock(ProcessedOrderValidator.class);
        serviceToTest = new BackendOrderSynService(processor, orderValidator);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateOrderAndProcessToBackendSystemOrThrow() throws Exception {
        final ShoppingCart shoppingCart = ShoppingCartBuilder.aShoppingCart().build();

        processor.process(anyObject(Order.class), eq(shoppingCart));
        orderValidator.validate(anyObject(Order.class));
        replayAll();

        serviceToTest.createOrderAndProcessToBackendSystemOrThrow(shoppingCart);

        verifyAll();
    }
}
