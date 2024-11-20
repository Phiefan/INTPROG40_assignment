package submission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTextAnalyser {

    @Test
    public void testCreateTextAnalyser() {
        TextAnalyser analyser = new TextAnalyser();
    }

    @Test
    public void testGetRows() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 0;

        // Act
        int actual = analyser.getRows();

        // Asser
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRowsAfterAnalysis() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 1;

        // Act
        analyser.analyze("Test on");
        int actual = analyser.getRows();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRowsAfterAnalyses() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 5;

        // Act
        analyser.analyze("Test on");
        analyser.analyze("Continue");
        analyser.analyze("Still going");
        analyser.analyze("Almost there");
        analyser.analyze("Test end");

        int actual = analyser.getRows();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCharacters() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 0;

        // Act
        int actual = analyser.getCharacters();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCharactersAfterAnalysis() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 7;

        // Act
        analyser.analyze("Test on");
        int actual = analyser.getCharacters();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCharactersAfterAnalyses() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 7 + 8 + 8;

        // Act
        analyser.analyze("Test on");
        analyser.analyze("Continue");
        analyser.analyze("Test end");

        int actual = analyser.getCharacters();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopFail() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = false;

        // Act
        analyser.analyze("Checking");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopPass() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        analyser.analyze("stop");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopOneUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        analyser.analyze("stOp");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAllUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        //
        analyser.analyze("STOP");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopInSentence() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = false;

        // Act
        analyser.analyze("A sentence with a stop");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAnalyses() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        analyser.analyze("Test on");
        analyser.analyze("continue");
        analyser.analyze("end after this");
        analyser.analyze("Stop");

        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWords() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 0;

        // Act
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWordsAfterAnalysis() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 1;

        // Act
        analyser.analyze("Testing");
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWordsAfterAnalyses() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 5;

        // Act
        analyser.analyze("Testing");
        analyser.analyze("that");
        analyser.analyze("words");
        analyser.analyze("are");
        analyser.analyze("counted");

        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWordsInSentence() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 4;

        // Act
        analyser.analyze("Words in a sentence");
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWordsInSentences() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 5 + 5 + 6;

        // Act
        analyser.analyze("Testing that program can handle");
        analyser.analyze("reading more than one sentence");
        analyser.analyze("and that words are handled correctly");
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLongestWord(){
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        String expected = "longest";

        // Act
        analyser.analyze("Test to get longest word");
        String actual = analyser.getLongestWord();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLongestWordAfterAnalyses(){
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        String expected = "sentences";

        // Act
        analyser.analyze("Test to get longest word");
        analyser.analyze("in a scenario with more sentences");
        analyser.analyze("the longest should be the same as expected");
        String actual = analyser.getLongestWord();

        // Assert
        assertEquals(expected, actual);
    }

    /*
    My classmate Deborah informed me about them using Strip() in their implementation and I question them about it.
    I did some testing on the side and figured out which situations it's good for and
    that I had not thought of those situations before this conversation.
     */
    @Test
    public void testBlankSpaceFirst(){
        /*
        Before the amended Strip() in the analyze method in the TextAnalyser
        I would have had an actual value of 4 in this test as the sentence provided as input
        would have resulted in the following array:
        " Testing is on " --> [, Testing, is, on]
        With the Strip() method I get instead the following:
        " Testing is on " --> [Testing, is, on]
         */
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 3;

        // Act
        analyser.analyze(" Testing is on ");
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testBlankSpacesStop(){
        /*
        I've chosen to keep my stop check non-sensitive so this test will give an actual value of false.
        If I wanted to have my program stop with this input I would have to change the following code in the analyze-method:
        if (str.equalsIgnoreCase("stop")) --> if (str.Strip().equalsIgnoreCase("stop"))
        If the requirement of the assignment was defined differently, aka blank spaces are not to be counted as characters
        then you could have used Strip() before the if-else statement and the characters per words would have been handled in a loop.
         */
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = false;

        // Act
        analyser.analyze("  stop  ");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }
}
