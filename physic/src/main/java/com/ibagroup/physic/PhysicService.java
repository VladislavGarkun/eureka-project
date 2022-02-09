package com.ibagroup.physic;

import com.ibagroup.common.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhysicService {
    private final PhysicRepo repo;

    private final String PHYSIC = "physic";

    @Autowired
    public PhysicService(PhysicRepo repo){
        this.repo = repo;
    }

    public Map<Long, Ticket> getPhysicTickets(Integer quantity) {
        Map<Long, Ticket> tickets = new HashMap<>();

        while(tickets.size() < quantity){
            Ticket ticket = repo.findTicketBySubjectAndNumber(PHYSIC, getRandomTicketNumber());
            if(!tickets.containsValue(ticket)){
                tickets.put(ticket.getId(), ticket);
            }
        }

        return tickets;
    }

    private Integer getRandomTicketNumber() {
        return (int)(Math.random() * repo.getTicketQuantity(PHYSIC)) + 1;
    }
}
