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

        System.out.println("The program has read "+analyser.getRows()+" rows of text\n"+
                "These rows consist of "+analyser.getCharacters()+" characters.");
    }
}
