package refactoring;

import java.math.BigDecimal;

public class CarrierCosts {

    public static CarrierCosts DHL_COST = new CarrierCosts(new Cost[]{new Cost("DE", new BigDecimal("6.90")),
                                                                      new Cost("AT", new BigDecimal("8.90")),
                                                                      new Cost("UK", new BigDecimal("10.90"))},
                                                           new Cost("DE", new BigDecimal("15.90")));

    public static CarrierCosts HERMES_COST = new CarrierCosts(new Cost[]{new Cost("DE", new BigDecimal("6.90")),
                                                                         new Cost("AT", new BigDecimal("6.90"))},
                                                              null);

    public static CarrierCosts UPS_COST = new CarrierCosts(new Cost[]{new Cost("DE", new BigDecimal("6.90")),
                                                                      new Cost("UK", new BigDecimal("8.90"))},
                                                           new Cost("DE", new BigDecimal("18.00")));

    private final Cost[] costs;
    private final Cost bulkyCost;

    private CarrierCosts(final Cost[] costs, final Cost bulky) {
        this.costs = costs;
        this.bulkyCost = bulky;
    }

    public Cost[] getCosts() {
        return costs;
    }

    public Cost getBulkyCost() {
        return bulkyCost;
    }

    public static CarrierCosts valueOf(final Carrier carrier) {
        switch(carrier.getType()) {
            case DHL: return DHL_COST;
            case HERMES: return HERMES_COST;
            case UPS: return UPS_COST;
            default: return DHL_COST;
        }
    }

    static final class Cost {
        final String locale;
        final BigDecimal price;

        Cost(final String locale, final BigDecimal price) {
            this.locale = locale;
            this.price = price;
        }

        public String getLocale() {
            return locale;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }
}
