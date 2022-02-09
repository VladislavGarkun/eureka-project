package com.ibagroup.math;

import com.ibagroup.common.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MathService {

    private final MathRepo repo;

    private final String MATH = "math";

    @Autowired
    public MathService(MathRepo repo){
        this.repo = repo;
    }

    public Map<Long, Ticket> getMathTickets(Integer quantity) {
        Map<Long, Ticket> tickets = new HashMap<>();

        while(tickets.size() < quantity){
            Ticket ticket = repo.findTicketBySubjectAndNumber(MATH, getRandomTicketNumber());
            if(!tickets.containsValue(ticket)){
                tickets.put(ticket.getId(), ticket);
            }
        }

        return tickets;
    }

    private Integer getRandomTicketNumber() {
        return (int)(Math.random() * repo.getTicketQuantity(MATH)) + 1;
    }
}