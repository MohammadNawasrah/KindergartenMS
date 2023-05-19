package com.nawasrah.schoolMS.teacherAdmin;
import org.springframework.stereotype.Repository;


@Repository
public class TeacherAdminModel {
    public int teacherId;
    public String name;
    public String password;
    public String userName;
    public int classNumber;

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
