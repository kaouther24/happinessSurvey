package com.compagny.survey.controller;

import com.compagny.survey.model.Survey;
import com.compagny.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/surveys")
public class AdminController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.createSurvey(survey);
    }

    @PutMapping("/{surveyId}")
    public Survey updateSurvey(@PathVariable String surveyId, @RequestBody Survey survey) {
        return surveyService.updateSurvey(surveyId, survey);
    }

    @DeleteMapping("/{surveyId}")
    public String deleteSurvey(@PathVariable String surveyId) {
        surveyService.deleteSurvey(surveyId);
        return "Survey deleted successfully";
    }
}