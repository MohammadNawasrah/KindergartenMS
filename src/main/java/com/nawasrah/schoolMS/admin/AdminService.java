package com.nawasrah.schoolMS.admin;

import com.nawasrah.schoolMS.core.ConstantData;
import com.nawasrah.schoolMS.core.HttpSessionPage;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
    public static boolean isAdmin(String password) {
        if (password.contains("@"))
            return true;
        return false;
    }

    public static boolean isAdminLogin(HttpSession session) {
       return  HttpSessionPage.getSession(session, ConstantData.admin) == null ? false : (boolean) HttpSessionPage.getSession(session,  ConstantData.admin);
    }
}
