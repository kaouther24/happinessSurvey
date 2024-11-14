package com.compagny.survey.repository;

import com.compagny.survey.model.SurveyResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SurveyAnswersRepository {

    private final Map<String, List<SurveyResponse>> responseData = new HashMap<>();

    public void save(SurveyResponse response) {
        responseData.computeIfAbsent(response.getSurveyId(), k -> new ArrayList<>()).add(response);
    }

    public List<SurveyResponse> findBySurveyId(String surveyId) {
        return responseData.getOrDefault(surveyId, new ArrayList<>());
    }

}
