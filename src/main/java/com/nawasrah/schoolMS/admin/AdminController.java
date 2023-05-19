package com.nawasrah.schoolMS.admin;

import com.nawasrah.schoolMS.core.ConstantData;
import com.nawasrah.schoolMS.core.HttpSessionPage;
import com.nawasrah.schoolMS.core.RedirectTo;
import com.nawasrah.schoolMS.core.ToView;
import com.nawasrah.schoolMS.student.StudentModel;
import com.nawasrah.schoolMS.student.StudentService;
import com.nawasrah.schoolMS.teacher.TeacherModel;
import com.nawasrah.schoolMS.teacher.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

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
            return ToView.toView("/student_info", "student", studentService.getAllStudent());

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

    @PostMapping(value = "/addNewTeacher", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String addNewTeacher(@RequestBody TeacherModel teacherForm) {
        System.out.println(teacherForm.getName());
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(teacherForm.getName());
        teacherModel.setPassword(teacherForm.getPassword());
        teacherModel.setUserName(teacherForm.getUserName());
        return teacherService.addNewTeacher(teacherModel);
    }

    @RequestMapping(value = "/addNewTeacher", method = RequestMethod.GET)
    public Object addNewTeacher(HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("Get/addNewTeacher");
        boolean isLogin = AdminService.isAdminLogin(session);
        if (isLogin) {
            redirectAttributes.addFlashAttribute(ConstantData.nameOfTeacher, HttpSessionPage.getSession(session, ConstantData.nameOfTeacher));
            return ToView.toView("add_teacher",ConstantData.nameOfTeacher,HttpSessionPage.getSession(session, ConstantData.nameOfTeacher));

        } else {
            return RedirectTo.redirectTo("/");
        }
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        System.out.println("Get/logout");
        HttpSessionPage.closeSession(session);
        return RedirectTo.redirectTo("/");
    }
}
