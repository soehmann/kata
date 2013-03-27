package refactoring;

public class BackendOrderSynService {

    private final Processor p;
    private final ProcessedOrderValidator v;

    public BackendOrderSynService(final Processor p, final ProcessedOrderValidator v) {
        this.p = p;
        this.v = v;
    }

    public void createOrderAndProcessToBackendSystemOrThrow(final ShoppingCart sc) throws IllegalStateException {
        final Order newOrder = new Order();

        p.process(newOrder, sc);

        if(!newOrder.isValid()) {
            throw new IllegalStateException("Order will not be processed");
        } else {
            v.validate(newOrder);
        }
    }
}
