package com.ibagroup.examinator;

import lombok.Data;

@Data
public class TicketAmountException extends Exception{

    private TicketAmountMessageDto ticketAmountMessageDto;

    public TicketAmountException(TicketAmountMessageDto ticketAmountMessageDto){
        this.ticketAmountMessageDto = ticketAmountMessageDto;
    }

}