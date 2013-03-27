package refactoring;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddressDataBuilder {

    private String lastName = "Boss";
    private String firstName = "Hugo";
    private String street = "Irgendwo da draussen im Wald hinter den Bergen bei den sieben Zwergen.";
    private String houseNo = "57a";
    private String zipCode = "77777";
    private String city = "Märchenland";
    private String addInfo = "4 Etage, Flur C, Gang A, 3 Tür rechts";
    private Locale country = Locale.GERMANY;

    private final Map<String, Object> data = new HashMap<String, Object>();

    private AddressDataBuilder() {}

    public static AddressDataBuilder aAddress() {
        return new AddressDataBuilder();
    }

    public Map<String, Object> build() {
        this.data.put("lastname", lastName);
        this.data.put("firstname", firstName);
        this.data.put("street", street);
        this.data.put("houseNo", houseNo);
        this.data.put("addInfo", addInfo);
        this.data.put("zipCode", zipCode);
        this.data.put("city", city);
        this.data.put("country", country);
        return data;
    }

    public AddressDataBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AddressDataBuilder withFirstname(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AddressDataBuilder withStreet(final String street) {
        this.street = street;
        return this;
    }

    public AddressDataBuilder withHouseNo(final String houseNo) {
        this.houseNo = houseNo;
        return this;
    }

    public AddressDataBuilder withAddInfo(final String addInfo) {
        this.addInfo = addInfo;
        return this;
    }

    public AddressDataBuilder withZipCode(final String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressDataBuilder withCity(final String city) {
        this.city = city;
        return this;
    }

    public AddressDataBuilder withCountry(final Locale country) {
        this.country = country;
        return this;
    }

    public AddressDataBuilder withAustria() {
        this.country = new Locale("de","AT");
        return this;
    }
}
