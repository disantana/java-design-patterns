package br.com.disantana.design.patterns.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquareBaloonTest extends Assert {

    private ScoreBoard squareBaloonScoreBoard;

    @Before
    public void setUp() throws Exception {
        squareBaloonScoreBoard = new ScoreBoard();
        squareBaloonScoreBoard.scoreAlgorithmBase = new SquareBaloon();
    }

    @Test
    public void testShouldShowScoreBoardForBaloon() {
        var square = squareBaloonScoreBoard.showScore(10, 5);
        assertEquals("Scoreboard igual a 90 para o baloon", square, "Scoreboar: 90");
    }

    @Test
    public void testCalculateScoreForBaloon() {
        var square = new SquareBaloon();
        int squareScore = square.calculateScore(10, 5);
        assertEquals(squareScore, 90);
    }
}