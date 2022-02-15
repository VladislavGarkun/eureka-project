package com.ibagroup.math;

import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
@RequiredArgsConstructor
public class MathController {

    private final MathService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketListDto getMathTickets(@RequestParam Integer quantity){
        TicketListDto tickets = service.getMathTickets(quantity);

        return tickets;
    }

}