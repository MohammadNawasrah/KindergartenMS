package com.nawasrah.schoolMS.teacher;

import com.nawasrah.schoolMS.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    List<TeacherModel> print() {
        return teacherRepository.findAll();
    }

    public boolean login(String username, String password) {
        TeacherModel teacherModel = teacherRepository.findByWhere("userName", username);
        if (teacherModel != null)
            if (password.equals(teacherModel.getPassword()))
                return true;

        return false;
    }

    public boolean loginAccess(String username) {
        TeacherModel teacherModel = teacherRepository.findByWhere("userName", username);
        return teacherModel.isLogin();
    }
}
