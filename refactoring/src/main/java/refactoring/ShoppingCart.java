package refactoring;


import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ShoppingCart {

    private final List<Item> items;
    private final Map<String, Object> billingAddressData;
    private final Map<String, Object> shippingAddressData;
    private final Carrier carrier;

    public ShoppingCart(final Map<String, Object> billingAddressData, final Map<String, Object> shippingAddressData,
                        final List<Item> items, final Carrier carrier) {
        this.billingAddressData = billingAddressData;
        this.shippingAddressData = shippingAddressData;
        this.items = items;
        this.carrier = carrier;
    }

    public String getBillingAddressLastname() {
        return billing("lastname");
    }

    public String getBillingAddressFirstname() {
        return billing("firstname");
    }

    public String getBillingAddressStreet() {
        return billing("street");
    }

    public String getBillingAddressHouseNo() {
        return billing("houseNo");
    }

    public String getBillingAddressZipCode() {
        return billing("zipCode");
    }

    public String getBillingAddressCity() {
        return billing("city");
    }

    public Locale getBillingCountry() {
        return (Locale)billingAddressData.get("country");
    }

    public String getShippingAddressLastname() {
        return shipping("lastname");
    }

    public String getShippingAddressFirstname() {
        return shipping("firstname");
    }

    public String getShippingAddressStreet() {
        return shipping("street");
    }

    public String getShippingAddressHouseNo() {
        return shipping("houseNo");
    }

    public String getShippingAddressAdditionalInformation() {
        return shipping("addInfo");
    }

    public String getShippingAddressZipCode() {
        return shipping("zipCode");
    }

    public String getShippingAddressCity() {
        return shipping("city");
    }

    public Locale getShippingCountry() {
        return (Locale)shippingAddressData.get("country");
    }

    public List<Item> getItems() {
        return items;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    private String billing(final String key) {
        return byKey(billingAddressData, key);
    }

    private String shipping(final String key) {
        return byKey(shippingAddressData, key);
    }

    private String byKey(final Map<String, Object> data, final String key) {
        return (String)data.get(key);
    }
}
