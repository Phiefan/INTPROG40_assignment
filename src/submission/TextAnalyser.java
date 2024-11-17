package submission;

public class TextAnalyser {
    private int rows, characters, words;
    private String longestWord;
    private boolean stopState;

    public TextAnalyser() {
        this.rows = 0;
        this.characters = 0;
        this.words = 0;
        this.longestWord = "";
        this.stopState = false;
    }

    public void analyze(String str) {
        if (str.equalsIgnoreCase("stop")) {
            this.stopState = true;
        } else {
            this.rows++;
            this.characters += str.length();
            String[] strArray = str.split(" ");
            this.words += strArray.length;
            for (String s : strArray) {
                this.longestWord = (s.length() > this.longestWord.length()) ? s : this.longestWord;
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCharacters() {
        return this.characters;
    }

    public int getWords() {
        return this.words;
    }

    public String getLongestWord() {
        return this.longestWord;
    }

    public boolean getStopState(){
        return this.stopState;
    }
}
