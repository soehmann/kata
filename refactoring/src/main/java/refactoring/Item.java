package refactoring;

import java.math.BigDecimal;

public class Item {

    private final int quantity;
    private final BigDecimal price;
    private final BigDecimal vat;
    private final boolean bulky;

    public Item(final int quantity, final BigDecimal price, final BigDecimal vat, final boolean bulky) {
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
        this.bulky = bulky;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public boolean isBulky() {
        return bulky;
    }
}
