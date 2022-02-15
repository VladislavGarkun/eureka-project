package com.ibagroup.physic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhysicRepo extends JpaRepository<Ticket, Long> {

    Integer countBySubject(String subject);

    List<Ticket> findAllBySubject(String subject);

    List<Ticket> findTicketsBySubjectAndNumberIn(String subject, List<Integer> numbers);

}