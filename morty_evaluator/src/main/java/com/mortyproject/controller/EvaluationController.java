package com.mortyproject.controller;

import com.micah.springapi.dto.EvaluationRequest;
import com.micah.springapi.dto.EvaluationResponse;
import com.micah.springapi.service.StatEvaluatorService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for evaluating Morty stats to determine training worthiness.
 * Delegates logic to the StatEvaluatorService.
 */
@RestController
@RequestMapping("/api/evaluate")
public class EvaluationController {

    private final StatEvaluatorService evaluator;

    public EvaluationController(StatEvaluatorService evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * Evaluates a Morty based on its stats to determine if it's worth training.
     * @param request the evaluation request containing stat values
     * @return an EvaluationResponse with score and recommendation
     */
    @PostMapping
    public EvaluationResponse evaluate(@Validated @RequestBody EvaluationRequest request) {
        return evaluator.evaluate(request);
    }
}
