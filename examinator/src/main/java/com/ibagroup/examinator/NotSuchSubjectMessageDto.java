package com.ibagroup.examinator;

import lombok.Data;

import java.util.List;

@Data
public class NotSuchSubjectMessageDto {
    private String message;
    private List<String> subjects;

    public NotSuchSubjectMessageDto(String message, List<String> notFindSubjects) {
        this.message = message;
        this.subjects = notFindSubjects;
    }
}