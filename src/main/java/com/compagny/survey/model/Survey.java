package com.compagny.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    private String id;
    private String title;
    private String description;
    private List<Question> questions;
}
