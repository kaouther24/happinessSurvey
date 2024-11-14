package com.compagny.survey.service;
import com.compagny.survey.model.Answer;
import com.compagny.survey.model.Survey;
import com.compagny.survey.model.SurveyResponse;
import com.compagny.survey.repository.SurveyAnswersRepository;
import com.compagny.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyAnswersRepository surveyAnswersRepository;
    public Survey createSurvey(Survey survey) {
        survey.setId(UUID.randomUUID().toString());
        survey.getQuestions().forEach(question -> {
            if (question.getId() == null || question.getId().isEmpty()) {
                question.setId(UUID.randomUUID().toString());
            }
        });
        return surveyRepository.save(survey);
    }

    public Survey getSurvey(String surveyId) {
        return surveyRepository.findById(surveyId);
    }

    public Survey updateSurvey(String surveyId, Survey updatedSurvey) {
        updatedSurvey.setId(surveyId);
        return surveyRepository.save(updatedSurvey);
    }

    public void deleteSurvey(String surveyId) {
        surveyRepository.deleteById(surveyId);
    }

    public void submitResponse(String surveyId, List<Answer> answers) {
        SurveyResponse response = new SurveyResponse(UUID.randomUUID().toString(), surveyId, answers);
        surveyAnswersRepository.save(response);
    }

    public List<SurveyResponse> getResponses(String surveyId) {
        return surveyAnswersRepository.findBySurveyId(surveyId);
    }
}
