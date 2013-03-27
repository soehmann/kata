package refactoring;

public class Address {

    private String data_1;
    private String data_2;
    private String data_3;
    private String data_4;
    private String data_5;
    private String data_6;
    private String data_7;
    private String data_8;

    public Address(final String data_1, final String data_2, final String data_3, final String data_4,
                   final String data_5, final String data_6, final String data_7, final String data_8) {
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        this.data_4 = data_4;
        this.data_5 = data_5;
        this.data_6 = data_6;
        this.data_7 = data_7;
        this.data_8 = data_8;
    }

    public Address(final String data_1, final String data_2, final String data_3,
                   final String data_4, final String data_5) {
        this.data_1 = data_1;
        this.data_3 = data_2;
        this.data_4 = data_3;
        this.data_6 = data_4;
        this.data_7 = data_5;
        this.data_8 = "DE";
    }

    public Address(final String data_1, final String data_2, final String data_3,
                   final String data_4, final String data_5, final String data_6) {
            this.data_1 = data_1;
            this.data_3 = data_2;
            this.data_4 = data_3;
            this.data_6 = data_4;
            this.data_7 = data_5;
            this.data_8 = data_6;
        }

    public String getLastname() {
        return data_1;
    }

    public String getFirstname() {
        return data_2;
    }

    public String getStreet() {
        return data_3;
    }

    public String getHouseNo() {
        return data_4;
    }

    public String getAddInfo() {
        return data_5;
    }

    public String getZipCode() {
        return data_6;
    }

    public String getCity() {
        return data_7;
    }

    public String getCountryIsoCode() {
        return data_8;
    }
}
