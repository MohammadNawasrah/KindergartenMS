package com.nawasrah.schoolMS.admin;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
@Service
public class AdminService {
    public static RedirectView toAdminView(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/student/student_info");
        return redirectView;
    }
}
