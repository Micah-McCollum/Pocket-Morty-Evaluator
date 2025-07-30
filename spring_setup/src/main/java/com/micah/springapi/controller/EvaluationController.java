package com.micah.springapi.controller;

import com.micah.springapi.dto.EvaluationRequest;
import com.micah.springapi.dto.EvaluationResponse;
import com.micah.springapi.service.StatEvaluatorService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
// Controller for evaluation of training worthiness for a given Morty
@RestController
@RequestMapping("/api/evaluate")
public class EvaluationController {

    private final StatEvaluatorService evaluator;

    public EvaluationController(StatEvaluatorService evaluator) {
        this.evaluator = evaluator;
    }

    @PostMapping
    public EvaluationResponse evaluate(@Validated @RequestBody EvaluationRequest request) {
        return evaluator.evaluate(request);
    }
}