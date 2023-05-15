package com.nawasrah.schoolMS.student;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/student_info")
    public ModelAndView studentInfo(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("isLogin") != (null))
            if ((boolean) session.getAttribute("isLogin")) {
                modelAndView.setViewName("/student_info");
                modelAndView.addObject("student", studentService.getAllStudent());
            }
        else {
                modelAndView.setViewName("/index");
                modelAndView.addObject("userName",session.getAttribute("userName"));
            }
        return modelAndView;
    }

    @GetMapping("/addStudentPage")
    public ModelAndView addStudentPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("isLogin") != (null))
            if ((boolean) session.getAttribute("isLogin")) {
                modelAndView.setViewName("/add_student");
                StudentModel mo = new StudentModel();
                modelAndView.addObject("StudentModel", mo);
            }
        else {
                modelAndView.setViewName("/index");
                modelAndView.addObject("userName",session.getAttribute("userName"));
            }

        return modelAndView;
    }

    @RequestMapping(value = "/addStudentPage", method = RequestMethod.POST)
    public RedirectView addStudent(@ModelAttribute("StudentModel") StudentModel studentForm) {
        StudentModel student = new StudentModel();
        student.setName(studentForm.getName());
        student.setNumberPhone(studentForm.getNumberPhone());
        student.setDateOfBirth(studentForm.getDateOfBirth());
        student.setIdCode(studentForm.getIdCode());
        student.setTeacherId(studentForm.getTeacherId());
        studentService.addNewS(student);

        return new RedirectView("/student/student_info");
    }

}
