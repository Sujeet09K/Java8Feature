package com.suj.java8feature.pojo;

import java.util.List;


public class Employee {
    private Integer empID;
    private String empName, country,  department;
    private List<String> project;
    private Float salary;

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", country='" + country + '\'' +
                ", department='" + department + '\'' +
                ", project=" + project +
                ", salary=" + salary +
                '}';
    }

    public Employee(Integer empID, String empName, String country, List<String> project, String department, Float salary) {
        this.empID = empID;
        this.empName = empName;
        this.country = country;
        this.project = project;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getProject() {
        return project;
    }

    public void setProject(List<String> project) {
        this.project = project;
    }
}
