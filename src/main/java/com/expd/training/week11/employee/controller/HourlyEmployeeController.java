package com.expd.training.week11.employee.controller;

import com.expd.training.week11.employee.model.Employee;
import com.expd.training.week11.employee.model.HourlyEmployee;
import com.expd.training.week11.employee.service.HourlyEmployeeService;
import com.expd.training.week11.employee.service.SalariedEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employee/hourly")
@RequiredArgsConstructor
public class HourlyEmployeeController {

    private final HourlyEmployeeService hourlyEmployeeService;

    @GetMapping
    public ResponseEntity<List<HourlyEmployee>> getEmployees() {
        return ResponseEntity.ok(hourlyEmployeeService.getAllHourlyEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HourlyEmployee> getHourlyEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(hourlyEmployeeService.getHourlyEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<HourlyEmployee> addHourlyEmployee(@RequestBody HourlyEmployee employee) {
        return ResponseEntity.ok(hourlyEmployeeService.addHourlyEmployee(employee));
    }

    @PutMapping("/id")
    public ResponseEntity<HourlyEmployee> updateHourlyEmployee(@PathVariable Long id, @RequestBody HourlyEmployee employee) {
        if (!Objects.equals(employee.getEmployeeId(), id))
            return ResponseEntity.notFound().build();
        boolean success = hourlyEmployeeService.updateHourlyEmployee(employee);
        return success ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<HourlyEmployee> deleteEmployee(@RequestBody HourlyEmployee employee) {
        boolean isDelete = hourlyEmployeeService.deleteHourlyEmployee(employee);
        return isDelete ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }
}
