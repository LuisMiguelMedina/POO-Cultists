package com.encora.movieapi.controllers;

import freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppErrorController implements ErrorController{
     
    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public void handle(HttpServletResponse response) throws IOException, TemplateException{
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("movieproject/src/main/resources/public/error"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        int code = response.getStatus();
        Map<String,Object> root = new HashMap<>();

        root.put("status", code);

        Template temp = cfg.getTemplate("xxx.ftlh");
        Writer out = response.getWriter();
        temp.process(root, out);
    }
}