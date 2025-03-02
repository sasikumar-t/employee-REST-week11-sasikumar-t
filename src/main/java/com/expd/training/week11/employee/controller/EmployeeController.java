package com.expd.training.week11.employee.controller;

import com.expd.training.week11.employee.model.Employee;
import com.expd.training.week11.employee.model.HourlyEmployee;
import com.expd.training.week11.employee.model.SalariedEmployee;
import com.expd.training.week11.employee.service.HourlyEmployeeService;
import com.expd.training.week11.employee.service.SalariedEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final HourlyEmployeeService hourlyEmployeeService;

    private final SalariedEmployeeService salariedEmployeeService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<HourlyEmployee> hourlyEmployeeList = hourlyEmployeeService.getAllHourlyEmployees();
        List<SalariedEmployee> salariedEmployeeList = salariedEmployeeService.getAllSalariedEmployees();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.addAll(hourlyEmployeeList);
        employeeList.addAll(salariedEmployeeList);
        return ResponseEntity.ok(employeeList);
    }

}
