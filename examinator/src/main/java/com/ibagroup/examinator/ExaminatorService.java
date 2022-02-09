package com.ibagroup.examinator;

import com.ibagroup.common.Ticket;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ExaminatorService {

    private final String EUREKA = "eureka-";
    private final String QUANTITY = "?quantity=";

    @Autowired
    EurekaClient eurekaClient;

    public Map<Long, Ticket> getTickets(List<SubjectDto> subjects) {
        Map<Long, Ticket> tickets = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();

        subjects.forEach(subject -> {
            String serviceName = getServiceName(subject.getName());
            String url = getServiceUrl(subject, serviceName);
            tickets.putAll(restTemplate.getForEntity(url, Map.class).getBody());
        });

        return tickets;
    }

    private String getServiceName(String subjectName) {
        return EUREKA + subjectName;
    }

    private String getServiceUrl(SubjectDto subject, String serviceName) {
        return eurekaClient.getApplication(serviceName).getInstances().get(0).getHomePageUrl() + subject.getName() + QUANTITY + subject.getQuantity();
    }
}
