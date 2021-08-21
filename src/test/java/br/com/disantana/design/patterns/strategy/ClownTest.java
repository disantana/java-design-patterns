package br.com.disantana.design.patterns.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClownTest {

    private ScoreBoard clownScoreBoard;

    @Before
    public void setUp() {
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