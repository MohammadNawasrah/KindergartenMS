package com.nawasrah.schoolMS.core;

import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

public class RedirectTo {
    public static RedirectView redirectTo(String url){
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(url);
        return  redirectView;
    }
    public static RedirectView redirectTo(String url, Map<String , String> flashAttribute){
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(url);
        return  redirectView;
    }
}
