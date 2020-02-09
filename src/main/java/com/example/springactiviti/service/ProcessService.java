package com.example.springactiviti.service;


import com.example.springactiviti.model.Employee;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author z.Taghizadeh
 *
 * responsible for starting the process
 */

@Service
public class ProcessService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    Map<String, Employee> employees = new HashMap<>();

    // start the process and set employee as variable
    public String startTheProcess(String assignee) {

        setEmployeeMap();

        Employee employee = employees.get(assignee);

        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", employee);

        runtimeService.startProcessInstanceByKey("simple-process", variables);

        return processInformation();
    }

    private void setEmployeeMap() {

        employees.put("zahra", new Employee("zahra", "Software Enginner"));
        employees.put("mina", new Employee("mina", "Technical Lead"));
        employees.put("shabnam", new Employee("shabnam", "Test Lead"));

    }

    // fetching process and task information
    public String processInformation() {

        List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();

        StringBuilder processAndTaskInfo = new StringBuilder();

        processAndTaskInfo.append("Number of process definition available: "
                + repositoryService.createProcessDefinitionQuery().count() + " | Task Details= ");

        taskList.forEach(task -> {

            processAndTaskInfo.append("ID: " + task.getId() + ", Name: " + task.getName() + ", Assignee: "
                    + task.getAssignee() + ", Description: " + task.getDescription());
        });

        return processAndTaskInfo.toString();
    }

    // fetch task assigned to employee
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    // complete the task
    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }
}
