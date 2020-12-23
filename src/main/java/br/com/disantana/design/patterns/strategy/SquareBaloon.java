package br.com.disantana.design.patterns.strategy;

public class SquareBaloon extends ScoreAlgorithmBase {

    @Override
    public int calculateScore(int taps, int multiplier) {
        return (taps * multiplier) + 40;
    }
}
