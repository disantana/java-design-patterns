package br.com.disantana.design.patterns.strategy;

public class ScoreBoard {

    public ScoreAlgorithmBase scoreAlgorithmBase;

    public String showScore(int taps, int multiplier) {
        return "Scoreboar: " + scoreAlgorithmBase.calculateScore(taps,multiplier);

    }
}
