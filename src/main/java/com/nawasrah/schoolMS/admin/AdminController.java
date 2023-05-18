package com.nawasrah.schoolMS.admin;

import com.nawasrah.schoolMS.core.HttpSessionPage;
import com.nawasrah.schoolMS.core.RedirectTo;
import com.nawasrah.schoolMS.core.ToView;
import com.nawasrah.schoolMS.student.StudentModel;
import com.nawasrah.schoolMS.student.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/panel")
    public Object adminPanel(HttpSession session) {
        boolean isLogin = AdminService.isAdminLogin(session);
        if (isLogin) {
            System.out.println("Get/panel");
            return ToView.toView("adminPanel");
        } else {
            return RedirectTo.redirectTo("/");
        }
    }

    @GetMapping("/student_info")
    public Object studentInfo(HttpSession session) {
        boolean isLogin = AdminService.isAdminLogin(session);
        if (isLogin) {
            return ToView.toView("/student_info","student",studentService.getAllStudent());

        } else {
            return RedirectTo.redirectTo("/");
        }
    }
    @RequestMapping(value = "/addStudentPage", method = RequestMethod.POST)
    public void addStudent(@RequestBody StudentModel studentForm) {
        StudentModel student = new StudentModel();
        student.setName(studentForm.getName());
        student.setNumberPhone(studentForm.getNumberPhone());
        student.setDateOfBirth(studentForm.getDateOfBirth());
        student.setIdCode(studentForm.getIdCode());
        student.setTeacherId(studentForm.getTeacherId());
        studentService.addNewS(student);

    }
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        System.out.println("Get/logout");
        HttpSessionPage.closeSession(session);
        return RedirectTo.redirectTo("/");
    }
}
