package com.ibagroup.history;

import com.ibagroup.common.TicketDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    List<TicketDto> ticketToTicketDto(List<Ticket> ticket);

}