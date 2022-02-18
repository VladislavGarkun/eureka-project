package com.ibagroup.physic;

import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/physic")
@RequiredArgsConstructor
public class PhysicController {

    private final PhysicService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketListDto getPhysicTickets(@RequestParam Integer quantity){
        TicketListDto tickets = service.getPhysicTickets(quantity);

        return tickets;
    }
}