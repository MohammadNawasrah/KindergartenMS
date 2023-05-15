package com.nawasrah.schoolMS.teacher;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class TeacherModel {
    public int teacherId;
    public String name;
    public String password;
    public String userName;
    public boolean isLogin=false;
}
