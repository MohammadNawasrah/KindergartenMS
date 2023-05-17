package com.nawasrah.schoolMS.core;

import jakarta.servlet.http.HttpSession;

public class HttpSessionPage {
    public static Object getSession(HttpSession session,String key) {
        return session.getAttribute(key);
    }
    public static void setSession(HttpSession session,String key,Object value) {
        session.setAttribute(key,value);
    }
    public static void closeSession(HttpSession session){
        session.invalidate();
    }
}
