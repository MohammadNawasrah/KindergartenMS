package com.nawasrah.schoolMS.student;

import com.nawasrah.schoolMS.core.HttpSessionPage;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student_info")
    public ModelAndView studentInfo(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        if (HttpSessionPage.getSession(session,"isLogin") != null)
            if (HttpSessionPage.getSession(session,"isLogin").equals(true)) {
                modelAndView.setViewName("/student_info");
                modelAndView.addObject("student", studentService.getAllStudent());
            }
        else {
                modelAndView.setViewName("/index");
                modelAndView.addObject("userName",session.getAttribute("userName"));
            }
        return modelAndView;
    }
}
