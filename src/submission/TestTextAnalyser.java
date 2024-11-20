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
        boolean actual = analyser.checkStop("Checking");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopPass() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = analyser.checkStop("stop");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopInSentence() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = false;

        // Act
        boolean actual = analyser.checkStop("A sentence with a stop");

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
        boolean actual = analyser.checkStop("stOp");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopAllUppercase() {
        // Arrange
        TextAnalyser analyser = new TextAnalyser();
        boolean expected = true;

        // Act
        boolean actual = analyser.checkStop("STOP");

        // Assert
        assertEquals(expected, actual);
    }
}
