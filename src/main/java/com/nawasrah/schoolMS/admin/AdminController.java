package com.nawasrah.schoolMS.admin;

import com.nawasrah.schoolMS.core.ToView;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @GetMapping("/admin_panel")
    public ModelAndView adminPanel() {
        System.out.println("Get/admin_panel");
        return ToView.toView("adminPanel");
    }
}
