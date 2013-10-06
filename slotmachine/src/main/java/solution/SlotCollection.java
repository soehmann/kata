package solution;

public class SlotCollection {

    public static final SlotCollection ALPHA_NUMERIC_DE =
            new SlotCollection(new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
                                          't','u','v','w','x','y','z','ö','ü','ä',' '});

    private final char[] values;

    private SlotCollection(final char[] values) {
        this.values = values;
    }

    public Character getValue(final int index) {
        if(values.length == 0) {
            return null;
        }

        if(index < 0 || index > values.length -1) {
            return null;
        }

        return values[index];
    }

    public int length() {
        return values.length;
    }
}
