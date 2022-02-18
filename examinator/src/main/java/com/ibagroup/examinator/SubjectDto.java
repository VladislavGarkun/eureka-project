package com.ibagroup.examinator;

import lombok.Data;

@Data
public class SubjectDto {

    private String subjectInfo;

    public SubjectDto(String subjectInfo){
        this.subjectInfo = subjectInfo;
    }

    public String getSubjectName(){
        return subjectInfo.split("-")[0];
    }

    public String getTicketQuantity(){
        return subjectInfo.split("-")[1];
    }

}