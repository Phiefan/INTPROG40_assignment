package submission;

public class TextAnalyser {
    private int rows, characters, words;
    private String longestWord;

    public TextAnalyser(){
        this.rows = 0;
        this.characters = 0;
        this.words = 0;
        this.longestWord = "";
    }

    public void textAnalysis(String str) {
        this.rows++;
        this.characters += str.length();
        this.words += sentenceAnalysis(str);
    }

    public int sentenceAnalysis(String str) {
        String[] strArray = str.split(" ");

        for (String s : strArray) {
            setLongestWord(s);
        }

        return strArray.length;
    }

    public void setLongestWord(String str) {
        if (str.length() >this.longestWord.length()){
            this.longestWord = str;
        }
    }

    public boolean stopCheck(String str) {
        return str.equalsIgnoreCase("stop");
    }

    public boolean analysis(String str) {
        boolean stop = false;

        if (this.stopCheck(str)) {
            stop = true;
        } else {
            this.textAnalysis(str);
        }

        return stop;
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
}
