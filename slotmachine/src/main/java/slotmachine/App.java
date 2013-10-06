package slotmachine;

public class App {

    public static void main( String[] args ) {
        final Slotmachine machine = new Slotmachine();

        for (int i=0; i < 100000; i++) {
            machine.play();
        }

    }
}
