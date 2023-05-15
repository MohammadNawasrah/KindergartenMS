package com.nawasrah.schoolMS.teacherAdmin;

import com.nawasrah.schoolMS.admin.AdminService;
import com.nawasrah.schoolMS.core.RedirectTo;
import com.nawasrah.schoolMS.core.ToView;
import com.nawasrah.schoolMS.teacher.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TeacherAdminController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    public ModelAndView loginPage() {
        System.out.println("Get/index");
        return ToView.toView("index");
    }

    @PostMapping("/login")
    public RedirectView processLoginForm(@RequestParam("username") String username, HttpSession session,
                                         @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        System.out.println("Post/login");
        Boolean authenticatedUser = teacherService.login(username, password);
        if (authenticatedUser) {
            session.setAttribute("isLogin", true);
            session.setAttribute("userName", username);
            if (AdminService.isAdmin(password))
                return RedirectTo.redirectTo("/admin_panel");
            return RedirectTo.redirectTo("/student/student_info");
        }
        redirectAttributes.addFlashAttribute("userName",username);
        return RedirectTo.redirectTo("/");
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        System.out.println("Get/logout");
        session.invalidate();
        return ToView.toView("index");
    }
}
