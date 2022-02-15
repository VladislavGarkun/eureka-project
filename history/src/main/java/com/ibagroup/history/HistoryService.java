package com.ibagroup.history;

import com.ibagroup.common.CommonMethods;
import com.ibagroup.common.TicketDto;
import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepo repo;
    private final TicketMapper mapper;

    private static final String HISTORY = "history";

    public TicketListDto getHistoryTickets(Integer quantity) {
        List<Ticket> ticketsList;
        List<TicketDto> ticketsListDto;

        if(quantity >= repo.countBySubject(HISTORY)){
            ticketsList = repo.findAllBySubject(HISTORY);
        }else {
            List<Integer> ticketNumbers = CommonMethods.getTicketNumbers(quantity, repo.countBySubject(HISTORY));
            ticketsList = repo.findTicketsBySubjectAndNumberIn(HISTORY, ticketNumbers);
        }

        ticketsListDto = mapper.ticketToTicketDto(ticketsList);
        TicketListDto ticketListDto = new TicketListDto(ticketsListDto);

        return ticketListDto;
    }

}