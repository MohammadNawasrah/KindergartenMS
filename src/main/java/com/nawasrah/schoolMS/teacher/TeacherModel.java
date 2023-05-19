package com.nawasrah.schoolMS.teacher;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@ToString
@Repository
public class TeacherModel {
    public int teacherId;
    public String name;
    public String password;
    public String userName;
}
