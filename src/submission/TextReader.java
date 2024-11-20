package submission;

import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextAnalyser analyser = new TextAnalyser();
        boolean stopState = false;

        while (!stopState){
            String read = scanner.nextLine();

            if (analyser.checkStop(read)){
                stopState = true;
            }else {
                analyser.analyze(read);
            }
        }

        System.out.println("The program has read "+analyser.getRows()+" rows of text\n"+
                "These rows consist of "+analyser.getCharacters()+" characters.");
    }
}
