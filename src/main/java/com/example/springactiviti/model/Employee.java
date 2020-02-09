package com.example.springactiviti.model;


/**
 * @author z.Taghizadeh
 */
public class Employee {

    private Long id;
    private String name;
    private String designation;

    public Employee() {
    }

    public Employee(String name, String designation) {

        this.name = name;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
