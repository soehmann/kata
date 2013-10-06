package solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordResourceReader {

    private final String encoding = "UTF-8";

    public Set<String> read(final String path) {
        if(path == null || path.trim().isEmpty()) {
            return Collections.emptySet();
        }

        final FileInputStream fileInputStream = openFileToRead(path);
        if(fileInputStream == null) {
            return Collections.emptySet();
        }

        return readWordsFromStream(fileInputStream);
    }

    private Set<String> readWordsFromStream(final FileInputStream stream) {
        final Scanner scanner = new Scanner(stream, encoding);

        final Set<String> words = new HashSet<String>();

        while (scanner.hasNextLine()){
            words.add(scanner.nextLine());
        }
        scanner.close();

        return words;
    }

    private FileInputStream openFileToRead(final String path) {
        try {
            return new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
