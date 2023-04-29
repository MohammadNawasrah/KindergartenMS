package com.nawasrah.schoolMS.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/createTableStudent")
    String createTable(){
        return "Done create table ";
    }
    @GetMapping("/addStudent")
    String insertNewS(){
        StudentModel studentModel=new StudentModel();
        studentModel.setName("mohammad al nawasrah");
        studentModel.setNumberPhone("0788375406");
        studentModel.setTeacherId(10);
        studentModel.setIdCode("101010");
        studentModel.setDateOfBirth(LocalDate.of(2000,8,5));
        return studentService.addNewS(studentModel);
    }
    @GetMapping("/showStudent")
    List<StudentModel> showAllStudent(){

        return studentService.getAllStudent();
    }
}
