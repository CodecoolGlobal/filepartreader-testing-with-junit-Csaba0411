package com.codecool;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (fromLine > toLine) throw new IllegalArgumentException("fromLine can't be bigger than toLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine have to be 1 or more!");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
        stream.forEach(s -> sb.append(s).append("\n"));
        return sb.toString();
    }


    public String readLines() throws IOException {
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        String[] strParts = read().split("\\n");
        for (String lines : strParts) {
            if (counter >= fromLine && counter <= toLine) {
                sb.append(lines).append("\n");
            }
            counter++;
        }
        return sb.toString();
    }

}

