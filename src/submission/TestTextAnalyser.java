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
        analyser.textAnalysis("Test on");
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
        analyser.textAnalysis("Test on");
        analyser.textAnalysis("Continue");
        analyser.textAnalysis("Still going");
        analyser.textAnalysis("Almost there");
        analyser.textAnalysis("Test end");

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
        analyser.textAnalysis("Test on");
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
        analyser.textAnalysis("Test on");
        analyser.textAnalysis("Continue");
        analyser.textAnalysis("Test end");

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
        boolean actual = analyser.stopCheck("Checking");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopPass() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = analyser.stopCheck("stop");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopInSentence() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = false;

        // Act
        boolean actual = analyser.stopCheck("A sentence with a stop");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAnalysis() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = false;
        actual = analyser.analysis("Test on");
        actual = analyser.analysis("continue");
        actual = analyser.analysis("end after this");
        actual = analyser.analysis("STOP");

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
        analyser.analysis("Testing");
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
        analyser.analysis("Testing");
        analyser.analysis("that");
        analyser.analysis("words");
        analyser.analysis("are");
        analyser.analysis("counted");

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
        int actual = analyser.sentenceAnalysis("Words in a sentence");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWordsInSentences() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        int expected = 5 + 5 + 6;

        // Act
        analyser.analysis("Testing that program can handle");
        analyser.analysis("reading more than one sentence");
        analyser.analysis("and that words are handled correctly");
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
        analyser.analysis("Test to get longest word");
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
        analyser.analysis("Test to get longest word");
        analyser.analysis("in a scenario with more sentences");
        analyser.analysis("the longest should be the same as expected");
        String actual = analyser.getLongestWord();

        // Assert
        assertEquals(expected, actual);
    }

    // Personally don't want a case-sensitive program
    @Test
    public void testStopOneUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = analyser.stopCheck("Stop");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAllUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = analyser.stopCheck("STOP");

        // Assert
        assertEquals(expected, actual);
    }
}
