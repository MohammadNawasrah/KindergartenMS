package com.nawasrah.schoolMS.admin;

import org.springframework.stereotype.Service;
@Service
public class AdminService {
    public static boolean isAdmin(String password) {
        if (password.contains("@1"))
            return true;
        return false;
    }
}
