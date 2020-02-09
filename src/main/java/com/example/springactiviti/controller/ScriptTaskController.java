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
@RequestMapping("/activiti")
public class ScriptTaskController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("script-task/groovy")
    public String groovyScriptTask() {

        runtimeService.startProcessInstanceByKey("groovy-script-task-process");

        return "check the console log...";
    }

    @GetMapping("script-task/js")
    public String jsScriptTask() {

        runtimeService.startProcessInstanceByKey("js-script-task-process");

        return "check the console log...";
    }
}