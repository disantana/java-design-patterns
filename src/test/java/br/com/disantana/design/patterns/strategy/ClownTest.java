package br.com.disantana.design.patterns.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClownTest extends Assert {

    private ScoreBoard clownScoreBoard;

    @Before
    public void setUp() throws Exception {
        clownScoreBoard = new ScoreBoard();
        clownScoreBoard.scoreAlgorithmBase = new Clown();
    }

    @Test
    public void testShouldShowScoreBoardForClown() {
        var baloon = clownScoreBoard.showScore(10, 5);
        assertEquals("Scoreboard igual a 40 para o clown", baloon, "Scoreboar: 40");
    }

    @Test
    public void testCalculateScoreForClown() {
        var clown = new Clown();
        int clownScore = clown.calculateScore(10, 5);
        assertEquals(clownScore, 40);
    }
}