package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader fPR1 = new FilePartReader();
        fPR1.setup("src/main/resources/text.txt",1 ,2);
        FileWordAnalyzer fWA= new FileWordAnalyzer(fPR1);
        try {
            fWA.getWordsOrderedAlphabetically();
            fWA.getWordsContainingSubstring ("et");
            fWA.getStringsWhichPalindromes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



