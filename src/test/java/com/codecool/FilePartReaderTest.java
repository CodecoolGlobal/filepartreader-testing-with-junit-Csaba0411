package com.codecool;

;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void throwIllegalArgumentExceptionIfToLineIsSmallerThenFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/text.txt", 5, 1));
    }

    @Test
    public void throwIllegalArgumentExceptionIfFromLineIsMinus() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/text.txt", -1, 2));
    }

    @Test
    public void testCorrectLinesRead() throws IOException {
        filePartReader.setup("src/main/resources/text.txt", 1, 1);
        assertEquals("Lorem ipsum dolod sit amet, consectetur adipiscing elit.\n", filePartReader.readLines());
    }

    @Test
    public void readFile() throws IOException {
        filePartReader.setup("src/main/resources/text.txt", 1, 1);
        assertEquals("Lorem ipsum dolod sit amet, consectetur adipiscing elit.\n" +
                "Integer tempor pulvinar nunc, tet malesuada quam convallis blandit.\n" +
                "Proin blandit pellentesque nulla nec aliquam.\n" +
                "Ut ac tincidunt erat. Donec sed non eleifend dolor.\n" +
                "In justo mauris, laoreet eu urna sit amet, egestas porttitor arcu.\n" +
                "Morbi pharetra, neque vitae pellentesque posuere, justo dui suscipit justo, vitae convallis eros felis sed arcu.\n" +
                "Pellentesque sit amet ultrices erat, nec aliquam nulla.\n" +
                "Proin et tellus non quam interdum luctus nec quis lectus.\n" +
                "Praesent porttitor urna et elit egestas, at rutrum nisl vehicula.\n" +
                "Proin gravida interdum rhoncus. Pellentesque efficitur neque ut viverra volutpat.\n", filePartReader.read());
    }


}