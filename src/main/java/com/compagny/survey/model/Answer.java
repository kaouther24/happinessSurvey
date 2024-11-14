package com.compagny.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private String questionId;
    private List<String> selectedOptions;
    private String openEndedAnswer;
}