package com.ibagroup.examinator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExaminatorControllerAdvice {

    @ExceptionHandler(NotSuchSubjectException.class)
    public ResponseEntity noSubjectException(NotSuchSubjectException e){
        NotSuchSubjectMessageDto response = new NotSuchSubjectMessageDto(e.getNotSuchSubjectMessageDto().getMessage(), e.getNotSuchSubjectMessageDto().getSubjects());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketAmountException.class)
    public ResponseEntity ticketAmountException(TicketAmountException e){
        TicketAmountMessageDto response = new TicketAmountMessageDto(e.getTicketAmountMessageDto().getMessage(), e.getTicketAmountMessageDto().getSubjects(), e.getTicketAmountMessageDto().getNotEnoughTickets());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}