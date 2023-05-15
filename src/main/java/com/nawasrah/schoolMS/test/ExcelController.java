package com.nawasrah.schoolMS.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {

    @Autowired ExcelUtils excelUtils;
    @PostMapping ("/upload-excel")
    public List<Map<String, String>> read(@RequestParam("file") MultipartFile file) throws IOException {
        // Parse the Excel file and get its data
        List<Map<String, String>> data = excelUtils.readExcel(file.getInputStream());
        return data;
    }
    @GetMapping ("/show")
    public ModelAndView uploadExcel() throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/test");
        return modelAndView;
    }
}