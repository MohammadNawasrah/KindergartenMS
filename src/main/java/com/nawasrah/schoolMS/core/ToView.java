package com.nawasrah.schoolMS.core;

import org.springframework.web.servlet.ModelAndView;

public class ToView {
    public static ModelAndView toView(String nameOfView) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/" + nameOfView);
        return modelAndView;
    }
}
