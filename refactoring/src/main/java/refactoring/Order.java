package refactoring;

import java.math.BigDecimal;

public class Order {

    private Address b;
    private Address d;
    private BigDecimal s;
    private boolean v;

    public Order() {
    }

    public Address getBilling() {
        return b;
    }

    public void setBilling(final Address a) {
        this.b = a;
    }

    public Address getDelivery() {
        return d;
    }

    public void setDelivery(final Address a) {
        this.d = a;
    }

    public BigDecimal getOrderSum() {
        return s;
    }

    public void setOrderSum(BigDecimal sum) {
        s = sum;
    }

    public void setValid(final boolean valid) {
        v = valid;
    }

    public boolean isValid() {
        return v;
    }
}
