
package com.codecool;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader fPR;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fPR = fpr;
    }

    public List getWordsOrderedAlphabetically () throws IOException {
        ArrayList<String> AlphaText = (ArrayList<String>) Arrays.stream(readTextToArray()).sorted().collect(Collectors.toList());
        return AlphaText;
    }

    public List getWordsContainingSubstring (String subString) throws IOException {
        ArrayList<String> wordsContainsSubstring = new ArrayList<>();
        for (String word: readTextToArray()) {
            if (word.contains(subString)) {
                wordsContainsSubstring.add(word);
            }
        } return wordsContainsSubstring;
    }

    public List getStringsWhichPalindromes () throws IOException {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : readTextToArray() ) {
            if (word.length() > 1 && word.equals(reverse(word))) {
                palindromes.add(word);
            }

        }
        System.out.println(palindromes);
        return palindromes;
    }


    public String[] readTextToArray() throws IOException {
        String wordsFromText = fPR.readLines();
        wordsFromText = wordsFromText.toLowerCase().trim().replaceAll("[.|,]", "").replaceAll("\\n", " ");
        String[] arr = wordsFromText.split(" ");
        return arr;
    }

    public static String reverse(String inputString) {
        StringBuilder sb = new StringBuilder();
        sb.append(inputString);
        sb.reverse();
        return sb.toString();
    }
}


