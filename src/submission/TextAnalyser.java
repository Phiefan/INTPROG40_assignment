package submission;

public class TextAnalyser {
    private int rows, characters;

    public void textAnalysis(String str) {
        this.rows++;
        this.characters += str.length();
    }

    public int getRows() {
        return this.rows;
    }

    public int getCharacters() {
        return this.characters;
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
}
