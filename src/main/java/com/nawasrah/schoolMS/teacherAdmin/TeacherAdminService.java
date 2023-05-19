package com.nawasrah.schoolMS.teacherAdmin;

import com.nawasrah.schoolMS.teacherAdmin.repository.TeacherAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherAdminService {
    @Autowired
    TeacherAdminRepository teacherAdminRepository;
    public String addNewUser(TeacherAdminModel teacherAdminModel){
        return   teacherAdminRepository.addNweTeacherOrAdmin(teacherAdminModel);
    }
}
