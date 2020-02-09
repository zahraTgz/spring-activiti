package com.example.springactiviti.controller;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z.Taghizadeh
 */
@RestController
@RequestMapping("activiti")
public class ServiceTaskController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("service/delegate")
    public String startTheDelegateProcess() {

        runtimeService.startProcessInstanceByKey("java-delegate-service-task-process");

        return "Check the console log...";
    }

    @GetMapping("service/expression")
    public String startTheExpressionProcess() {

        runtimeService.startProcessInstanceByKey("method-expression-service-task-process");

        return "Check the console log...";
    }
}
