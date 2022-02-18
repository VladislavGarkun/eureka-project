package com.ibagroup.examinator;

import com.ibagroup.common.TicketListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/examinator")
@RequiredArgsConstructor
public class ExaminatorController {

    private final ExaminatorService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTickets(@RequestParam(name = "subject") List<String> subjects) throws NotSuchSubjectException, TicketAmountException {
        List<SubjectDto> subjectDto = service.createListSubjectDto(subjects);

        TicketListDto tickets = service.getTickets(subjectDto);

        return ResponseEntity.ok(tickets.getTicketListDto());
    }

}