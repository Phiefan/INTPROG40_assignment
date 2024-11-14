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

        System.out.println("The program has read "+analyser.getRows()+" rows of text.\n"+
                "These rows has a total of "+analyser.getCharacters()+" characters " +
                "and consists of "+analyser.getWords()+" words.\n" +
                "The longest word read is ["+analyser.getLongestWord()+"].");
    }
}
