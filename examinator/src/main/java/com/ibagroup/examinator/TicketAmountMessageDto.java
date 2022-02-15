package com.ibagroup.examinator;

import lombok.Data;

import java.util.List;

@Data
public class TicketAmountMessageDto {

    private String message;
    private List<String> subjects;
    private List<Integer> notEnoughTickets;

    public TicketAmountMessageDto(String message, List<String> notFindSubjects, List<Integer> notEnoughTickets) {
        this.message = message;
        this.subjects = notFindSubjects;
        this.notEnoughTickets = notEnoughTickets;
    }

}