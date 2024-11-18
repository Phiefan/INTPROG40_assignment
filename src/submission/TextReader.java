package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // Creating an object of the Scanner class
        TextAnalyser analyser = new TextAnalyser(); // Creating a TextAnalyser object

        // Loop will continue while the stopState in the TextAnalyser object is false
        while (!analyser.getStopState()) {
            // Reading in text in the attribute read
            String read = scanner.nextLine();
            // Sending the value of read to be analysed by the TextAnalyser object
            analyser.analyse(read);
        }

        // Printing out the result
        System.out.println("\nRESULT");
        System.out.println("Rows: " + analyser.getRows() + "\n" +
                "Characters: " + analyser.getCharacters() + "\n" +
                "Words: " + analyser.getWords() + "\n" +
                "Longest word: " + analyser.getLongestWord());
    }
}
