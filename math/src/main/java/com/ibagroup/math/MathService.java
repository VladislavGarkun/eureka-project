package com.ibagroup.math;

import com.ibagroup.common.CommonMethods;
import com.ibagroup.common.TicketDto;
import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MathService {

    private final MathRepo repo;
    private final TicketMapper mapper;

    private static final String MATH = "math";

    public TicketListDto getMathTickets(Integer quantity) {
        List<Ticket> ticketsList;
        List<TicketDto> ticketsListDto;

        if(quantity >= repo.countBySubject(MATH)){
            ticketsList = repo.findAllBySubject(MATH);

        }else {
            List<Integer> ticketNumbers = CommonMethods.getTicketNumbers(quantity, repo.countBySubject(MATH));
            ticketsList = repo.findTicketsBySubjectAndNumberIn(MATH, ticketNumbers);
        }

        ticketsListDto = mapper.ticketToTicketDto(ticketsList);
        TicketListDto ticketListDto = new TicketListDto(ticketsListDto);

        return ticketListDto;
    }

}