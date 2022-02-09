package com.ibagroup.math;

import com.ibagroup.common.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    private final MathService service;

    @Autowired
    public MathController(MathService service){
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, Ticket> getMathTickets(@RequestParam Integer quantity){
        Map<Long, Ticket> tickets = service.getMathTickets(quantity);

        return tickets;
    }

}
