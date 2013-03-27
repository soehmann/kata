package refactoring;

public class Carrier {

    public static final Carrier HERMES = new Carrier(CarrierType.HERMES, new String[]{"DE", "AT"});

    public static final Carrier DHL = new Carrier(CarrierType.DHL, new String[]{"DE", "AT", "UK"});

    public static final Carrier UPS = new Carrier(CarrierType.UPS, new String[]{"DE", "UK"});

    public static final Carrier[] carriers = new Carrier[]{DHL, HERMES, UPS};

    private CarrierType type;
    private final String[] locales;

    private Carrier(final CarrierType type, final String[] locales) {
        this.type = type;
        this.locales = locales;;

    }

    public CarrierType getType() {
        return type;
    }

    public String[] getLocales() {
        return locales;
    }

}
