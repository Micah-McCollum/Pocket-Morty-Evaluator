package com.micah.springapi.controller;

import com.micah.springapi.dto.EvaluationRequest;
import com.micah.springapi.dto.EvaluationResponse;
import com.micah.springapi.service.StatEvaluatorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluate")
public class EvaluationController {

    private final StatEvaluatorService evaluator;

    public EvaluationController(StatEvaluatorService evaluator) {
        this.evaluator = evaluator;
    }

    @PostMapping
    public EvaluationResponse evaluate(@Valid @RequestBody EvaluationRequest request) {
        return evaluator.evaluate(request);
    }
}