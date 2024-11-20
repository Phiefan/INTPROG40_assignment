package submission;

public class TextAnalyser {
    private int rows, characters;

    public TextAnalyser() {
        this.rows = 0;
        this.characters = 0;
    }

    public void analyze(String str) {
        this.rows++;
        this.characters += str.length();
    }

    public int getRows() {
        return this.rows;
    }

    public int getCharacters() {
        return this.characters;
    }

    public boolean checkStop(String str) {
        return str.equalsIgnoreCase("stop");
    }
}
