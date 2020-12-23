package br.com.disantana.design.patterns.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaloonTest extends Assert {

    private ScoreBoard baloonScoreBoard;

    @Before
    public void setUp() throws Exception {
        baloonScoreBoard = new ScoreBoard();
        baloonScoreBoard.scoreAlgorithmBase = new Baloon();
    }

    @Test
    public void testShouldShowScoreBoardForBaloon() {
        var baloon = baloonScoreBoard.showScore(10, 5);
        assertEquals("Scoreboard igual a 30 para o baloon", baloon, "Scoreboar: 30");
    }

    @Test
    public void testCalculateScoreForBaloon() {
        var baloon = new Baloon();
        int baloonScore = baloon.calculateScore(10, 5);
        assertEquals(baloonScore, 30);
    }
}