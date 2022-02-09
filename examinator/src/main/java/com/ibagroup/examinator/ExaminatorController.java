package com.ibagroup.examinator;


import com.ibagroup.common.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/examinator")
public class ExaminatorController {

    private final ExaminatorService service;

    @Autowired
    public ExaminatorController(ExaminatorService service){
        this.service = service;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTickets(@RequestBody List<SubjectDto> subjects){
        Map<Long, Ticket> tickets = service.getTickets(subjects);

        return ResponseEntity.ok(tickets.values());
    }
}
