package refactoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartBuilder {

    private Map<String, Object> billingAddressData = new HashMap<String, Object>();
    private Map<String, Object> deliveryAddressData = new HashMap<String, Object>();
    private List<Item> items = new ArrayList<Item>();
    private Carrier carrier = Carrier.HERMES;

    private ShoppingCartBuilder() {}

    public static ShoppingCartBuilder aShoppingCart() {
        return new ShoppingCartBuilder();
    }

    public ShoppingCart build() {
        return new ShoppingCart(billingAddressData, deliveryAddressData, items, carrier);
    }

    public ShoppingCartBuilder withItem(final ItemBuilder itemBuilder) {
        this.items.add(itemBuilder.build());
        return this;
    }

    public ShoppingCartBuilder withItem(final Item item) {
        this.items.add(item);
        return this;
    }

    public ShoppingCartBuilder withDeliveryAddress(final AddressDataBuilder addressDataBuilder) {
        this.deliveryAddressData = addressDataBuilder.build();
        return this;
    }

    public ShoppingCartBuilder withBillingAddress(final AddressDataBuilder addressDataBuilder) {
        this.billingAddressData = addressDataBuilder.build();
        return this;
    }

    public ShoppingCartBuilder withCarrier(final Carrier carrier) {
        this.carrier = carrier;
        return this;
    }
}
