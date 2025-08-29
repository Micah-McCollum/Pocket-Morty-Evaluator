package com.micah.springapi.dto;

/**
 * DTO returned by the evaluation endpoint.
 * Contains calculated score, a boolean flag for worthiness,
 * and a recommendation string.
 */
public class EvaluationResponse {
    private boolean worthTraining;
    private int score;
    private String recommendation;

    public boolean isWorthTraining() { return worthTraining; }
    public void setWorthTraining(boolean worthTraining) { this.worthTraining = worthTraining; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}