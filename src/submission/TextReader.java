package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextAnalyser analyser = new TextAnalyser();
        boolean stop = false;

        while (!stop){
            String read = scanner.nextLine();
            stop = analyser.analysis(read);
        }

        System.out.println("You've read in "+analyser.getRows()+" rows of text " +
                "consisting of "+analyser.getCharacters()+" characters.");
    }
}
