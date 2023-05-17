package com.nawasrah.schoolMS.core;
import org.springframework.web.servlet.ModelAndView;

public class ToView {
    public static ModelAndView toView(String nameOfView) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/" + nameOfView);
        return modelAndView;
    }
    public static ModelAndView toView(String nameOfView,String attributeName,Object object) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/" + nameOfView);
        modelAndView.addObject(attributeName,object);
        return modelAndView;
    }
}
