package solution;

import java.net.URL;

public class App {

    public static void main( String[] args ) {

        final URL url = ClassLoader.getSystemResource("words-de.txt");
        final WordResourceReader reader = new WordResourceReader();
        final SlotmachineFactory factory = new SlotmachineFactory(reader);
        final Slotmachine machine = factory.create(url.getFile(), 8, SlotCollection.ALPHA_NUMERIC_DE);

        for (int i=0; i < 100000; i++) {
            play(machine, i);
        }

    }

    private static void play(final Slotmachine slotmachine, int counter) {
        final String result = slotmachine.play();
        if(result != null) {
            System.out.println(String.format("Versuch %s hat mit \"%s\" gewonnen!", counter, result));
        }
    }


}
