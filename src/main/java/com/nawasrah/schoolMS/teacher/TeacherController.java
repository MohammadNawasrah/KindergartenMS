package com.nawasrah.schoolMS.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/teachers")
    public List<TeacherModel> displayAllTeacher(){
        return  teacherService.print();
    }
}
