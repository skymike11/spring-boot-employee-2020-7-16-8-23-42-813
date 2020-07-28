package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZHUDO2
 * @Date 7/28/2020 4:57 PM
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        employees.remove(employees.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .orElse(null));
    }

    @Override
    public void updateEmployee(Employee employee) {
        for (int index = 0; index < employees.size(); index++) {
            if (employees.get(index).getId() == employee.getId()) {
                employees.set(index, employee);
                break;
            }
        }
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        if (StringUtils.isEmpty(employeeId)) {
            return null;
        }
        return this.employees.stream().filter(employee -> employeeId == employee.getId()).findFirst().orElse(null);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employees;
    }
}