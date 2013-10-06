package solution;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordResourceReaderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private WordResourceReader reader;

    @Before
    public void setUp() throws Exception {
        reader = new WordResourceReader();
    }

    @Test
    public void testReadSuccessful() throws Exception {
        String fileResource = createFileResource();

        Set<String> words = reader.read(fileResource);

        assertEquals(words.size(), 3);
        assertTrue(words.contains("Worte"));
        assertTrue(words.contains("Test"));
        assertTrue(words.contains("Fehler"));
    }

    @Test
    public void tryRead_byResourceIs_null() throws Exception {
        assertEquals(reader.read(null), Collections.EMPTY_SET);
    }

    @Test
    public void tryRead_byResourceIs_empty() throws Exception {
        assertEquals(reader.read(" "), Collections.EMPTY_SET);
    }

    @Test
    public void tryRead_byFileNotFound() throws Exception {
        assertEquals(reader.read("fileNotFound_resource"), Collections.EMPTY_SET);
    }

    private String createFileResource() throws IOException {
        final File file = folder.newFile("words.txt");
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

        bufferedWriter.write("Worte");
        bufferedWriter.newLine();
        bufferedWriter.write("Test");
        bufferedWriter.newLine();
        bufferedWriter.write("Fehler");
        bufferedWriter.close();

        return file.getAbsolutePath();
    }
}
