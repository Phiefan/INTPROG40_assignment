package submission;

public class TextAnalyser {
    private int rows, characters;
    private boolean stopState;

    public TextAnalyser() {
        this.rows = 0;
        this.characters = 0;
        this.stopState = false;
    }

    public void analyze(String str) {
        if (str.equalsIgnoreCase("stop")) {
            this.stopState = true;
        } else {
            this.rows++;
            this.characters += str.length();
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCharacters() {
        return this.characters;
    }

    public boolean getStopState() {
        return this.stopState;
    }
}
