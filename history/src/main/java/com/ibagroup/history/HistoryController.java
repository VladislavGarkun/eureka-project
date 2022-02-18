package com.ibagroup.history;

import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketListDto getMathTickets(@RequestParam Integer quantity){
        TicketListDto tickets = service.getHistoryTickets(quantity);

        return tickets;
    }

}