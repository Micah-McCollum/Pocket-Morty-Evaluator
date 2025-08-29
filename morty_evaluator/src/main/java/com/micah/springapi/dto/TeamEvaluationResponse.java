package com.micah.springapi.dto;

import java.util.Map;

/**
 * DTO used to summarize the type distribution within a team
 * and provide a balancing recommendation.
 */
public class TeamEvaluationResponse {
    private Map<String, Integer> typeCounts;
    private String recommendation;

    public Map<String, Integer> getTypeCounts() {
        return typeCounts;
    }

    public void setTypeCounts(Map<String, Integer> typeCounts) {
        this.typeCounts = typeCounts;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}