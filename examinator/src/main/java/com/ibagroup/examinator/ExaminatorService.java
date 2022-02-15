package com.ibagroup.examinator;

import com.ibagroup.common.TicketDto;
import com.ibagroup.common.TicketListDto;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ExaminatorService {

    private final String EUREKA = "eureka-";
    private final String QUANTITY = "?quantity=";
    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;

    public TicketListDto getTickets(List<SubjectDto> subjects) throws NotSuchSubjectException, TicketAmountException {
        List<TicketDto> ticketDto = new ArrayList<>();

        List<String> notFindSubjects = getNotFoundSubjects(subjects);
        if(!notFindSubjects.isEmpty()){
            throw new NotSuchSubjectException(new NotSuchSubjectMessageDto("No subjects found", notFindSubjects));
        }

        subjects.forEach(subject -> {
            String url = getServiceUrl(subject);
            ticketDto.addAll(restTemplate.getForObject(url, TicketListDto.class).getTicketListDto());
        });

        TicketListDto tickets = new TicketListDto(ticketDto);

        List<String> subjectsWithNotEnoughTickets = new ArrayList<>();
        List<Integer> notEnoughQuantity = new ArrayList<>();

        subjects.forEach(subject -> {
            long ticketQuantity = tickets.getTicketListDto()
                    .stream()
                    //.collect(Collectors.groupingBy(TicketDto::getSubject))
                    //.get(subject.getSubjectName())
                    .filter(ticket -> ticket.getSubject().equals(subject.getSubjectName()))
                    //.size();
                    .count();
            if(Integer.valueOf(subject.getTicketQuantity()) > ticketQuantity){
                subjectsWithNotEnoughTickets.add(subject.getSubjectName());
                notEnoughQuantity.add(Integer.valueOf(subject.getTicketQuantity()) - (int)ticketQuantity);
            }
        });

        if(!subjectsWithNotEnoughTickets.isEmpty()){
            throw new TicketAmountException(new TicketAmountMessageDto("No enough tickets", subjectsWithNotEnoughTickets, notEnoughQuantity));
        }

        return tickets;
    }

    private List<String> getServiceNames() {
        List<Application> applications = eurekaClient.getApplications().getRegisteredApplications();
        List<String> serviceNames = new ArrayList<>();
        applications.forEach(application -> {
            serviceNames.add(application.getInstancesAsIsFromEureka().get(0).getVIPAddress());
        });

        return serviceNames;
    }

    private String getServiceUrl(SubjectDto subject) {
        StringBuilder url = new StringBuilder();

        String serviceName = EUREKA + subject.getSubjectName();

        url.append(eurekaClient.getApplication(serviceName).getInstances().get(0).getHomePageUrl());
        url.append(subject.getSubjectName());
        url.append(QUANTITY);
        url.append(subject.getTicketQuantity());

        return url.toString();
    }

    private List<String> getNotFoundSubjects(List<SubjectDto> subjects){
        List<String> serviceNames = getServiceNames();
        List<String> notFindSubjects = new ArrayList<>();

        for(int i = 0; i < subjects.size(); i++) {
            String serviceName = EUREKA + subjects.get(i).getSubjectName();
            if (!serviceNames.contains(serviceName)) {
                notFindSubjects.add(serviceName.split("-")[1]);
            }
        }

        return notFindSubjects;
    }

    public List<SubjectDto> createListSubjectDto(List<String> subjects) {
        List<SubjectDto> subjectDtos = new ArrayList<>();
        subjects.forEach(s -> {
            subjectDtos.add(new SubjectDto(s));
        });

        return subjectDtos;
    }
}