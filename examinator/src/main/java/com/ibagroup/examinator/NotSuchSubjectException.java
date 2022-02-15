package com.ibagroup.examinator;

import lombok.Data;

@Data
public class NotSuchSubjectException extends Exception{

    private NotSuchSubjectMessageDto notSuchSubjectMessageDto;

    public NotSuchSubjectException(NotSuchSubjectMessageDto notSuchSubjectMessageDto) {
        this.notSuchSubjectMessageDto = notSuchSubjectMessageDto;
    }
}