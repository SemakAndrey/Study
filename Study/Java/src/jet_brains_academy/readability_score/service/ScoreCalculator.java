package jet_brains_academy.readability_score.service;

import jet_brains_academy.readability_score.entity.TextData;

public class ScoreCalculator {

    private TextData textData;
    private String currentScore;
    private int counterCalculation;
    private int averageAge = 0;
    private double ari = 0.0;
    private double fk = 0.0;
    private double smog = 0.0;
    private double cl = 0.0;

    public ScoreCalculator(TextData textData) {
        this.textData = textData;

    }

    public void printRes(Double score) {

        switch ((int) Math.round(score)) {
            case 1:
                System.out.println("(about 6 year olds).");
                averageAge += 6;
                break;
            case 2:
                System.out.println("(about 7 year olds).");
                averageAge += 7;
                break;
            case 3:
                System.out.println("(about 9 year olds).");
                averageAge += 9;
                break;
            case 4:
                System.out.println("(about 10 year olds).");
                averageAge += 10;
                break;
            case 5:
                System.out.println("(about 11 year olds).");
                averageAge += 11;
                break;
            case 6:
                System.out.println("(about 12 year olds).");
                averageAge += 12;
                break;
            case 7:
                System.out.println("(about 13 year olds).");
                averageAge += 13;
                break;
            case 8:
                System.out.println("(about 14 year olds).");
                averageAge += 14;
                break;
            case 9:
                System.out.println("(about 15 year olds).");
                averageAge += 15;
                break;
            case 10:
                System.out.println("(about 16 year olds).");
                averageAge += 16;
                break;
            case 11:
                System.out.println("(about 17 year olds).");
                averageAge += 17;
                break;
            case 12:
                System.out.println("(about 18 year olds).");
                averageAge += 18;
                break;
            case 13:
                System.out.println("(about 24 year olds).");
                averageAge += 24;
                break;
            default:
                System.out.println("(about 24+ year olds).");
                averageAge += 24;
                break;
        }

    }

    public void calculate(String currentScore) {
        this.currentScore = currentScore;
        this.counterCalculation = "all".equals(currentScore.toLowerCase()) ? 4 : 1;

        switch (this.currentScore.toLowerCase()) {
            case "all":
                automatedReadabilityIndex();
                testsFleschKincaidReadability();
                simpleMeasureOfGobbledygook();
                colemanLiauIndex();
                break;
            case "ari":
                automatedReadabilityIndex();
                break;
            case "fk":
                testsFleschKincaidReadability();
                break;
            case "smog":
                simpleMeasureOfGobbledygook();
                break;
            case "cl":
                colemanLiauIndex();
                break;
        }

    }

    private void printCurrentAlgorithm(String algName, double val) {
        System.out.printf("%s: %.2f ", algName, val);
        printRes(val);
    }

    public void print() {

        switch (this.currentScore.toLowerCase()) {
            case "all":
                printCurrentAlgorithm("Automated Readability Index", this.ari);
                printCurrentAlgorithm("Flesch–Kincaid readability tests", this.fk);
                printCurrentAlgorithm("Simple Measure of Gobbledygook", this.smog);
                printCurrentAlgorithm("SColeman–Liau index", this.cl);
                break;
            case "ari":
                printCurrentAlgorithm("Automated Readability Index", this.ari);
                break;
            case "fk":
                printCurrentAlgorithm("Flesch–Kincaid readability tests", this.fk);
                break;
            case "smog":
                printCurrentAlgorithm("Simple Measure of Gobbledygook", this.smog);
                break;
            case "cl":
                printCurrentAlgorithm("Coleman–Liau index", this.cl);
                break;
        }

        System.out.printf("\nThis text should be understood in average by %.2f year olds.\n", (double) averageAge / counterCalculation);

    }

    private void automatedReadabilityIndex() {

        this.ari = 4.71 * textData.getCharacters() / textData.getWords().size() + .5 * textData.getWords().size() / textData.getSentences().size() - 21.43;

    }

    private void testsFleschKincaidReadability() {

        this.fk = 0.39 * textData.getWords().size() / textData.getSentences().size() + 11.8 * textData.getSyllables() / textData.getWords().size() - 15.59;

    }

    private void simpleMeasureOfGobbledygook() {

        this.smog = 1.043 * Math.sqrt(textData.getPolysyllables() * 30.0 / textData.getSentences().size()) + 3.1291;

    }

    private void colemanLiauIndex() {

        this.cl = .0588 * textData.getCharacters() / textData.getWords().size() * 100 - .296 * textData.getSentences().size() / textData.getWords().size() * 100 - 15.8;

    }

}
