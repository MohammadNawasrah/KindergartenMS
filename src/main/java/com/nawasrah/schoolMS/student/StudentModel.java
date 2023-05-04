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
    public Long id;
    public String name;
    public String numberPhone;
    public String dateOfBirth;
    public String idCode;
    public int teacherId;

}
