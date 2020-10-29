package com.codecool;

import com.codecool.FilePartReader;
import com.codecool.FileWordAnalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    public void setUp() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 1, 2);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }


    @Test
    public void checkIsItAlphabetical() throws IOException {
        List<String> expected = Arrays.asList("adipiscing", "amet", "blandit", "consectetur", "convallis",
                "dolod", "elit", "integer", "ipsum", "lorem", "malesuada", "nunc", "pulvinar", "quam", "sit", "tempor", "tet");
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void checkSubStringInTheText() throws IOException {
        List<String> expected = Arrays.asList("amet", "consectetur", "tet");
        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("et") );
    }

    @Test
    public void checkWordsListPalidrom() throws IOException {
        List<String> expected = Arrays.asList("dolod", "tet");
        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}