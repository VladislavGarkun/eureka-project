package com.ibagroup.physic;

import com.ibagroup.common.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhysicRepo extends JpaRepository<Ticket, Long> {

    @Query(value = "select count(t.subject) from Ticket t where t.subject = :subject")
    Integer getTicketQuantity(String subject);

    Ticket findTicketBySubjectAndNumber(String subject, Integer number);

}
