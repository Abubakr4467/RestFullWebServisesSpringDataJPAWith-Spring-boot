package com.dailycodebuffer.dailycodebuffer.controller;

import com.dailycodebuffer.dailycodebuffer.model.Employee;
import com.dailycodebuffer.dailycodebuffer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController  {

    @Qualifier("employeeServiceImp")
    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

//            {
//                "firstName" : "Abubakr",
//                    "lastName" : "Abdullaev",
//                    "emailId": "Abubakr.iut.1992@gmail.com",
//                    "department": "ComPro"
//            }


    @GetMapping
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id){
        return  employeeService.deleteById(id);
    }



}
