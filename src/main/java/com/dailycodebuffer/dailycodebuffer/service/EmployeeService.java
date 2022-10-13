package com.dailycodebuffer.dailycodebuffer.service;

import com.dailycodebuffer.dailycodebuffer.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteById(String id);
}
