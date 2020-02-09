package com.example.springactiviti.service;

import org.springframework.stereotype.Service;

/**
 * @author z.Taghizadeh
 */
@Service
public class MethodExpressionService {

    public void myService() {

        System.out.println("Method Expression Service Task executed successfully.");

        System.out.println("And the Multiply of 12 * 2= " + (12 * 2));
    }
}
