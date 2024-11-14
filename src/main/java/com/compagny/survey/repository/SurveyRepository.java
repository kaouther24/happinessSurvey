package com.compagny.survey.repository;

import com.compagny.survey.model.Survey;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SurveyRepository {
    private final Map<String, Survey> surveyData = new HashMap<>();

    public Survey save(Survey survey) {
        surveyData.put(survey.getId(), survey);
        return survey;
    }

    public Survey findById(String id) {
        return surveyData.get(id);
    }

    public Map<String, Survey> findAll() {
        return surveyData;
    }

    public void deleteById(String id) {
        surveyData.remove(id);
    }
}