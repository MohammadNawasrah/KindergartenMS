package com.nawasrah.schoolMS.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@ToString
public class StudentModel {
    private Long id;
    private String name;
    private String numberPhone;
    private LocalDate dateOfBirth;
    private String idCode;
    private int teacherId;

}
