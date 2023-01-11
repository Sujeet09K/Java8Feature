package com.suj.java8feature.job;

import com.suj.java8feature.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;


public class LambdaApp {
    static List<Employee> empList = new ArrayList<>();
    public static void main(String[] args) {
        getEmployees();
        System.out.println("Total Emp count :"+empList.stream().count());
        System.out.println("=========Map,FlatMap,Distinct,Sorted,ForEach=================");
        empList.stream().map(e -> e.getProject())
                .flatMap(e -> e.stream())
                .distinct().sorted()
                .forEach(System.out::println);
        System.out.println("===========Collectors Joining===============");
        String projectList = empList.stream().map(Employee::getProject)
                .flatMap(e -> e.stream())
                .distinct().sorted()
                .collect(Collectors.joining(",","[","]"));
        System.out.println("Project List : "+projectList);

        System.out.println("============Skip==============");
        empList.stream().skip(1).forEach(System.out::println);

        System.out.println("============Find First==============");
        Optional<Employee> emp = empList.stream().filter(e -> "depart_1".equals(e.getDepartment()))
                .findFirst();
        System.out.println(emp.toString());
        System.out.println("============reduce==============");
        Float total_ctc = empList.stream()
                .map(e -> e.getSalary()).reduce(0f, (c,e) -> c+e);
        System.out.println("Total CTC: "+total_ctc);

        System.out.println("============Sum of Salary using Collectors==============");
        Double double_ctc = empList.stream()
                        .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Total CTC: "+double_ctc);

        System.out.println("============Salary stat using Collectors==============");
        DoubleSummaryStatistics double_ctc_stat = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(double_ctc_stat);

        System.out.println("============Grouping By==============");
        Map<String, List<Employee>> deptMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        deptMap.entrySet().stream().forEach(System.out::println);

        System.out.println("============Grouping By, CollectingAndThen==============");
        Map dept_sal = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(
                        Comparator.comparingDouble(Employee::getSalary)
                ),Optional::get)));

        dept_sal.entrySet().stream().forEach(System.out::println);

    }

    static public void getEmployees(){
            empList.add(new Employee(1, "emp_1","India",
                    Arrays.asList("project_1"), "depart_1", 1000f));
        empList.add(new Employee(2, "emp_2","US",
                Arrays.asList("project_2", "project_4"), "depart_2", 9000f));
        empList.add(new Employee(3, "emp_3","India",
                Arrays.asList("project_1", "project_3"), "depart_3", 3000f));
        empList.add(new Employee(4, "emp_4","UK",
                Arrays.asList("project_6", "project_0"), "depart_1", 8000f));

    }

}
