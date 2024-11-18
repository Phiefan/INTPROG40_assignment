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
        analyser.analyse("Test on");
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
        analyser.analyse("Test on");
        analyser.analyse("Continue");
        analyser.analyse("Still going");
        analyser.analyse("Almost there");
        analyser.analyse("Test end");

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
        analyser.analyse("Test on");
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
        analyser.analyse("Test on");
        analyser.analyse("Continue");
        analyser.analyse("Test end");

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
        analyser.analyse("Checking");
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
        analyser.analyse("stop");
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
        analyser.analyse("A sentence with a stop");
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
        analyser.analyse("Test on");
        analyser.analyse("continue");
        analyser.analyse("end after this");
        analyser.analyse("STOP");
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
        analyser.analyse("Testing");
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
        analyser.analyse("Testing");
        analyser.analyse("that");
        analyser.analyse("words");
        analyser.analyse("are");
        analyser.analyse("counted");

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
        analyser.analyse("Words in a sentence");
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
        analyser.analyse("Testing that program can handle");
        analyser.analyse("reading more than one sentence");
        analyser.analyse("and that words are handled correctly");
        int actual = analyser.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLongestWord() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        String expected = "longest";

        // Act
        analyser.analyse("Test to get longest word");
        String actual = analyser.getLongestWord();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLongestWordAfterAnalyses() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        String expected = "sentences";

        // Act
        analyser.analyse("Test to get longest word");
        analyser.analyse("in a scenario with more sentences");
        analyser.analyse("the longest should be the same as expected");
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
        analyser.analyse("stOp");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAllUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        analyser.analyse("STOP");
        boolean actual = analyser.getStopState();

        // Assert
        assertEquals(expected, actual);
    }
}
