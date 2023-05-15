package com.nawasrah.schoolMS.teacherAdmin;
import com.nawasrah.schoolMS.teacher.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TeacherAdminController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @PostMapping("/login")
    public RedirectView processLoginForm(@RequestParam("username") String username, HttpSession session,
                                         @RequestParam("password") String password, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        Boolean authenticatedUser = teacherService.login(username, password);
        if (authenticatedUser) {
            RedirectView redirectView = new RedirectView();
            session.setAttribute("isLogin", true);
            session.setAttribute("userName", username);
            redirectView.setUrl("/student/student_info");
           return  redirectView;
        }
        redirectAttributes.addFlashAttribute("userName",username);
        return   new RedirectView("/");
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        session.invalidate();
        modelAndView.setViewName("/index");

        return modelAndView;
    }


}
