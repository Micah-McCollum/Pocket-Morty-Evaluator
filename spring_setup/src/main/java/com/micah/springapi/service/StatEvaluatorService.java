package com.micah.springapi.service;

import com.micah.springapi.dto.EvaluationRequest;
import com.micah.springapi.dto.EvaluationResponse;
import org.springframework.stereotype.Service;
// Service class for training worthiness evaluation, currently adds all stats and factors level into account when determining3
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