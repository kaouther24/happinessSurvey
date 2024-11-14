package com.compagny.survey.controller;

import com.compagny.survey.model.Answer;
import com.compagny.survey.model.Survey;
import com.compagny.survey.model.SurveyResponse;
import com.compagny.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/{surveyId}")
    public Survey getSurvey(@PathVariable String surveyId) {
        return surveyService.getSurvey(surveyId);
    }

    @PostMapping("/{surveyId}/responses")
    public String submitResponses(@PathVariable String surveyId, @RequestBody List<Answer> responses) {
        return "Responses submitted successfully";
    }

    @GetMapping("/{surveyId}/responses")
    public List<SurveyResponse> getSurveyResponses(@PathVariable String surveyId) {
        return surveyService.getResponses(surveyId);
    }
}