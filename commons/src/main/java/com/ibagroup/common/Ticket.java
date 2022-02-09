package com.ibagroup.common;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private Integer number;
    private String content;

}
