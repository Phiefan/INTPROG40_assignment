package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextAnalyser analyser = new TextAnalyser();

        while (!analyser.getStopState()){
            String read = scanner.nextLine();
            analyser.analyze(read);
        }

        System.out.println("\nRESULT");
        System.out.printf("Rows: %s\n" +
                "Characters: %s\n" +
                "Words: %s\n" +
                "Longest word: %s\n",
                analyser.getRows(), analyser.getCharacters(),
                analyser.getWords(), analyser.getLongestWord());
    }
}
