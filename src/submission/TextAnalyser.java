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

    public void analyse(String str) {
        if (str.equalsIgnoreCase("stop")) {
            // If str is equal to stop set the stopState attribute to true
            this.stopState = true;
        } else {
            // Increment the rows attribute with 1
            this.rows++;
            // Add the length of str to the characters attribute
            this.characters += str.length();

            // Separate str into strArray by blank spaces
            String[] strArray = str.split(" ");
            // Add the length of the strArray, aka the amount of elements in the array, to the words attributes
            this.words += strArray.length;
            // Loop through the strArray to check whether one of the elements are longer than the value in longestWord
            for (String s : strArray) {
                if (s.length() > this.longestWord.length()) {
                    // If the element's length is bigger than of longestWord
                    // set the longestWord attribute to the value of the element
                    this.longestWord = s;
                }
            }
        }
    }

    public int getRows() {
        // Returns the value of the rows attribute
        return this.rows;
    }

    public int getCharacters() {
        // Returns the value of the characters attribute
        return this.characters;
    }

    public int getWords() {
        // Returns the value of the words attribute
        return this.words;
    }

    public String getLongestWord() {
        // Returns the value of longestWord
        return this.longestWord;
    }

    public boolean getStopState() {
        // Returns the value of stopState
        return this.stopState;
    }
}
