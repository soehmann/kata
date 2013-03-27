package refactoring;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemBuilder {
    private int quantity = 1;
    private BigDecimal price = new BigDecimal("11.90");
    private BigDecimal vat = new BigDecimal("1.90");
    private boolean bulky = false;

    private ItemBuilder(){}

    public static ItemBuilder aItem() {
        return new ItemBuilder();
    }

    public Item build() {
        return new Item(quantity, price, vat, bulky);
    }

    public ItemBuilder withQuantity(final int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemBuilder withPrice(final String price) {
        this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        return this;
    }

    public ItemBuilder withVat(final String vat) {
        this.vat = new BigDecimal(vat).setScale(2,RoundingMode.HALF_UP);
        return this;
    }

    public ItemBuilder isBulky() {
        this.bulky = true;
        return this;
    }
}
