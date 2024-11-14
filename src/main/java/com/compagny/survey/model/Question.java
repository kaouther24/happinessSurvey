package com.compagny.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Question {
    private String id;
    private String text;
    private QuestionType type;
    private List<String> options;

    public Question(String text, QuestionType type, List<String> options) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.type = type;
        this.options = options;
    }
}