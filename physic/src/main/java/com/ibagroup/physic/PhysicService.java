package com.ibagroup.physic;

import com.ibagroup.common.CommonMethods;
import com.ibagroup.common.TicketDto;
import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhysicService {

    private final PhysicRepo repo;
    private final TicketMapper mapper;

    private static final String PHYSIC = "physic";

    public TicketListDto getPhysicTickets(Integer quantity) {
        List<Ticket> ticketsList;
        List<TicketDto> ticketsListDto;

        if(quantity >= repo.countBySubject(PHYSIC)){
            ticketsList = repo.findAllBySubject(PHYSIC);

        }else {
            List<Integer> ticketNumbers = CommonMethods.getTicketNumbers(quantity, repo.countBySubject(PHYSIC));
            ticketsList = repo.findTicketsBySubjectAndNumberIn(PHYSIC, ticketNumbers);
        }

        ticketsListDto = mapper.ticketToTicketDto(ticketsList);
        TicketListDto ticketListDto = new TicketListDto(ticketsListDto);

        return ticketListDto;
    }
}