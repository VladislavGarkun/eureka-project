package com.ibagroup.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketListDto {

    List<TicketDto> ticketListDto;

    public TicketListDto(){}

    public TicketListDto(List<TicketDto> ticketListDto){
        this.ticketListDto = new ArrayList<>();
        this.ticketListDto.addAll(ticketListDto);
    }

}
