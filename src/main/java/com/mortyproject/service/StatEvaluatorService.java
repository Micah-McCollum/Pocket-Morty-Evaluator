package com.mortyproject.service;

import com.mortyproject.dto.EvaluationRequest;
import com.mortyproject.dto.EvaluationResponse;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for evaluating Morty stat blocks to determine training worthiness.
 * Uses a custom scoring formula to return an evaluation recommendation.
 */
@Service
public class StatEvaluatorService {

    public EvaluationResponse evaluate(EvaluationRequest request) {
        int score = calculateScore(request);
        boolean worthIt = score >= 75;

        EvaluationResponse response = new EvaluationResponse();
        response.setScore(score);
        response.setWorthTraining(worthIt);
        response.setRecommendation(
            worthIt ?
                "Good stats — worth training." :
                "Low rolled stats — better to catch another."
        );

        return response;
    }
    
    /**
     * Calculates the Morty's evaluation score based on base stats and level.
     * Formula: score = 0.5 * level + hp + attack + defense + speed
     */
    private int calculateScore(EvaluationRequest request) {
        return (int) (
            request.getLevel() * 0.5 +
            request.getHp() +
            request.getAttack() +
            request.getDefense() +
            request.getSpeed()
        );
    }
}