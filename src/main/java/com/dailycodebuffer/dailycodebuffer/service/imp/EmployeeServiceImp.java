package com.dailycodebuffer.dailycodebuffer.service.imp;

import com.dailycodebuffer.dailycodebuffer.error.EmployeeNotFoundException;
import com.dailycodebuffer.dailycodebuffer.model.Employee;
import com.dailycodebuffer.dailycodebuffer.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImp  implements EmployeeService {

    List<Employee> employees = new ArrayList<>();


    @Override
    public Employee save(Employee employee){

        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }

        employees.add(employee);
        return employee;
    }


    @Override
    public List<Employee> getAllEmployees(){
        return employees;
    }

//    @Override
//    public Employee getEmployeeById(String id) {
//        return employees
//                .stream()
//                .filter(employee -> employee.getEmployeeId().equals(id))
//                .findFirst()
//                .get();
//    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
//              .orElseThrow(() -> new RuntimeException("" + "Employee not found with Id : " + id));
              .orElseThrow(() -> new EmployeeNotFoundException("" + "Employee not found with Id : " + id));
//                .orElseThrow(() -> new RuntimeException("" + "Employee not found with Id : " + id));  //for genericExpHandler


    }

    @Override
    public String  deleteById(String id) {
         Employee employee =   employees
                 .stream()
                 .filter(e -> e.getEmployeeId().equals(id))
                 .findFirst()
                 .get();
         employees.remove(employee);
         return "Employee deleted with id : " +id;

    }
}
