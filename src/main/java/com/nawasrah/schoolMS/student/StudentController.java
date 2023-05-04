package com.nawasrah.schoolMS.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/createTableStudent")
    String createTable() {
        return "Done create table ";
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping("/student_info")
    public ModelAndView studentInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/student_info");
        modelAndView.addObject("student", studentService.getAllStudent());
        return modelAndView;
    }

    @GetMapping("/addStudentPage")
    public ModelAndView addStudentPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/add_student");
        StudentModel mo = new StudentModel();
        modelAndView.addObject("StudentModel", mo);
        return modelAndView;
    }

    @RequestMapping(value = "/addStudentPage", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("StudentModel") StudentModel studentForm) {
        StudentModel student = new StudentModel();
        student.setName(studentForm.getName());
        student.setNumberPhone(studentForm.getNumberPhone());
        student.setDateOfBirth(studentForm.getDateOfBirth());
        student.setIdCode(studentForm.getIdCode());
        student.setTeacherId(studentForm.getTeacherId());
        studentService.addNewS(student);
//        studentService.deleteStudent();

        return studentInfo();
    }

    @GetMapping("/showStudent")
    List<StudentModel> showAllStudent(){

        return studentService.getAllStudent();
    }
}
