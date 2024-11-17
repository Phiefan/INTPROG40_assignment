package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextAnalyser analyser = new TextAnalyser();

        do {
            String read = scanner.nextLine();
            analyser.analyze(read);
        } while (!analyser.getStopState());

        System.out.println("\nRESULT");
        System.out.printf("""
                        Rows:           %s
                        Characters:     %s
                        Words:          %s
                        Longest word: %s
                        """,
                analyser.getRows(), analyser.getCharacters(),
                analyser.getWords(), analyser.getLongestWord());
    }
}
