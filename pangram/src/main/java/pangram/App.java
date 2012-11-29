package pangram;

/**
 * Pangram
 */
public class App 
{
    public static void main( String[] args ) {
        output(check("Ich finde es hier an der Quelle sehr warm"));
        output(check("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern"));
    }

    private static Pangram check(final String input) {
        return new Pangram(new Sentence(input));
    }

    private static void output(final Pangram pangram) {
        System.out.println("Pangram: " + pangram.getPangramSentence());
        System.out.println("Available letters: " + pangram.getAvailableLetters());
        System.out.println("Missed letters: " + pangram.getMissedLetters());
    }
}
