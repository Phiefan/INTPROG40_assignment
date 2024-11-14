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

        System.out.println("The program has read "+analyser.getRows()+" rows of text\n"+
                "These rows consist of "+analyser.getCharacters()+" characters.");
    }
}
