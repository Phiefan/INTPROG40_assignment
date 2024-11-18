package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextAnalyser analyser = new TextAnalyser();

        while (!analyser.getStopState()) {
            String read = scanner.nextLine();
            analyser.analyse(read);
        }

        System.out.println("\nRESULT");
        System.out.println("Rows: " + analyser.getRows() + "\n" +
                "Characters: " + analyser.getCharacters() + "\n" +
                "Words: " + analyser.getWords() + "\n" +
                "Longest word: " + analyser.getLongestWord());
    }
}
